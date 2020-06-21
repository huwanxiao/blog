package demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * demo1包用于学习方法增强、代理实现
 * 1.动态代理的底层实现代码 demo1&demo2
 */
public class Spring_aop1 {

    @Test
    public void demo1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("demo2.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
//        jdk的动态代理，用于实现了接口的类的代理
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.save();
        proxy.delete();
        proxy.update();
        proxy.find();
    }

    @Test
    public void demo2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("demo2.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        //        cglib的动态代理，用于没有实现接口的类的代理
        UserDao proxy = (UserDao) new MyCglibProxy((UserDaoImpl) userDao).createProxy();
        proxy.save();
        proxy.delete();
        proxy.update();
        proxy.find();
    }
    @Test
    public void demo3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("demo2.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
    }
}
