package com.imooc.ioc.demo2;

/**
 * Bean2的静态工厂 静态工厂的的作用就是把bean的方法封装了 通过工厂操作bean
 */
public class Bean2Factory {
    public static Bean2 createBean2(){
        System.out.println("Bean2Factory has worked");
        return new Bean2();
    }
}
