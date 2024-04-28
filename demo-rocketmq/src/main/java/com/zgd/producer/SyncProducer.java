package com.zgd.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author zgd
 */
public class SyncProducer {

    public static final int MESSAGE_COUNT = 100;

    public static void main(String[] args) throws Exception {

        // 初始化一个producer并设置Producer group name
        DefaultMQProducer producer = new DefaultMQProducer("producerB");
        // 设置NameServer地址
        producer.setNamesrvAddr("121.5.13.173:9876");
        producer.setSendMsgTimeout(60*1000);
        // 启动producer
        producer.start();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            // 创建一条消息，并指定topic、tag、body等信息，tag可以理解成标签，对消息进行再归类，RocketMQ可以在消费端对tag进行过滤
            /* Topic */
            Message msg = new Message("topicB" ,
                    /* Tag */
                    "TagB" ,
                    /* Message body */
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 利用producer进行发送，并同步等待发送结果
            /*
            * SendResult [sendStatus=SEND_OK, msgId=7F0000010E5E18B4AAC22D9957DB0000, offsetMsgId=79050DAD000078C90000000000000030,
            * messageQueue=MessageQueue [topic=topicA, brokerName=RaftNode00, queueId=11], queueOffset=0]
            *
            * */
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        // 一旦producer不再使用，关闭producer
        producer.shutdown();
    }
}