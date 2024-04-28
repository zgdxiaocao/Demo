package com.zgd.generic;

import com.zgd.generic.pojo.Apple;
import com.zgd.generic.pojo.Banana;

/**
 * @author zgd
 */
public class GenericMain {

    /**
     * 参考：<a href="https://blog.csdn.net/s10461/article/details/53941091">...</a>
     * 泛型只在编译阶段有用。
     * <p>
     * 泛型的作用：
     * 1.多种数据类型执行相同的代码逻辑，实现代码的复用
     * 2.泛型类型在使用的时候指定，不需要强制类型转换
     * <p>
     * <p>
     * 泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型 。
     */

    public static void main(String[] args) {
        // 泛型类测试
        GenericClasses<Number> genericNumber = new GenericClasses<Number>();
        genericNumber.setT(1);
        print(genericNumber);

        GenericClasses<Integer> genericInteger = new GenericClasses<Integer>();
        genericInteger.setT(2);
        print(genericInteger);

        // 泛型方法测试
        GenericMethod<Apple> genericMethod = new GenericMethod<Apple>();
        genericMethod.printFruit(new Apple());
        genericMethod.printFruit(new Banana());

    }

    /**
     * 在使用的时候要使用泛型通配符
     */
    public static void print(GenericClasses<?> tmp) {
        System.out.println(tmp.getT());
    }
}
