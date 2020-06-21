package com.imooc.ioc.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过demo2包学习bean的管理
 * bean实例化的三种形式
 */
public class spring_demo2 {
    @Test
    public void demo1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");

    }
    @Test
    public void demo2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");

    }
    @Test
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");

    }
}
