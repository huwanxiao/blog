package com.imooc.ioc.demo1;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    String name;
    public void  sayHello(){
        System.out.println("hello"+name);
    }

    public String getName() {
        return name;
    }

    public UserServiceImpl() {
        System.out.println("第一步：初始化");
    }

    public void setName(String name) {
        System.out.println("第二步：设置属性");
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步：设置bean的名称Userservice");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步：了解工厂信息");
    }

    public void setup() {
        System.out.println("第七步：lmpl被初始化了...");
    }

    public void teardown() {
        System.out.println("第十一步：lmpl被销毁了...");  //这是客户自己指定的销毁方法
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：属性设置后");
    }

    public void run() {
        System.out.println("第九步：业务逻辑");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("第十步：执行Spring的销毁方法");   //这是spring自带的销毁方法
    }
}
