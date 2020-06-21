package com.imooc.ioc.demo1;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

//通过demo1包学习spring的创建
public class spring_demo1 {

    /**
     * 传统方式
     */
    @Test
    public void demo1(){
        System.out.println("====通过传统方式创建的类====");
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }


    /**
     * Spring方式
     * 介绍两个常用工厂类 传统工厂类BeanFactory与新版本的工厂类ApplicationContext
     * 区别是BeanFactory类实例是当用到getbean()函数时才会创建实例
     * 而applicationContext类实例则是在加载文件时把全部的单例模式的类创建出来
     * 现在一般用Application类对象用的多
     * 加载方式的类有两种，一种是在类文件中加载，一种是在磁盘系统文件里面加载。对应两种加载函数
     */

    @Test
    public void demo2(){
        System.out.println("====通过ApplicationContext工厂类创建的类====");
        //创建spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext fileSystem = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
        //通过工厂获得bean
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();  //hello李四.属性可以在bean里定义
        UserService userService1 = (UserService) fileSystem.getBean("userService");
        userService1.sayHello();  //hello李四.属性可以在bean里定义
        System.out.println("=======end=========");
    }


    /**
     * 传统方式的spring
     */
    @Test
    public void demo3() {
        System.out.println("====通过传统的工厂类创建类====");
        //创建工厂
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        BeanFactory beanFactory1= new XmlBeanFactory(new FileSystemResource("D:\\applicationContext.xml"));
        //通过工厂获得Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();  //hello李四.属性可以在bean里定义
        UserService userService1 = (UserService) beanFactory1.getBean("userService");
        userService1.sayHello();  //hello李四.属性可以在bean里定义
        System.out.println("=======end=========");
    }
}
