package com.zgd.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * @author zgd
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException {
        // 用来接受MQ回调的监听器接口
        // 这里实现执行本地事务、commit、rollback、回调查询等逻辑
        TransactionListener transactionListener = new TransactionListenerImpl();

        // 创建一个支持事务消息的Producer
        TransactionMQProducer producer = new TransactionMQProducer("transactionProducerGroup");
        producer.setNamesrvAddr("121.5.13.173:9876");
        producer.setSendMsgTimeout(60 * 1000);

        // 创建一个线程池，用来处理RocketMQ回调的请求
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });

        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();

        Message msg = new Message("topicB",
                /* Tag */
                "TagB",
                /* Message body */
                ("Hello RocketMQ, transaction").getBytes(RemotingHelper.DEFAULT_CHARSET)
        );

        // 将消息作为half消息发送出去；同步请求
        producer.sendMessageInTransaction(msg, null);
        System.out.println("发送half消息成功");
        producer.shutdown();
    }

    static class TransactionListenerImpl implements TransactionListener {
        private final ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

        // half消息发送成功，执行本地事务
        @Override
        public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
            try {
                // 执行本地事务，执行成功返回commit
                System.out.println(Thread.currentThread().getName() + " :收到half回调，执行本地事务");

                localTrans.put(msg.getTransactionId(), 1);
                return LocalTransactionState.COMMIT_MESSAGE;
            } catch (Exception e) {
                // 执行本地事务失败，标记half消息无效

                System.out.println("执行本地事务异常，rollback");
                localTrans.put(msg.getTransactionId(), 2);
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        }

        @Override
        public LocalTransactionState checkLocalTransaction(MessageExt msg) {
            Integer status = localTrans.get(msg.getTransactionId());
            if (null != status) {
                switch (status) {
                    case 1:
                        return LocalTransactionState.COMMIT_MESSAGE;
                    case 2:
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    // UNKNOWN表示位置状态，会出发mq的回查机制
                    default:
                        return LocalTransactionState.UNKNOW;
                }
            }
            return LocalTransactionState.COMMIT_MESSAGE;
        }
    }
}