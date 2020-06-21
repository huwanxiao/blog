package demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * demo2包使用spring方式使用动态代理：一般切面及其属性配置
 */

public class Spring_demo2 {
    @Test
    public void demo1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("demo2.xml");
        UserDao userDao = (UserDao) app.getBean("userDaoProxy");
        userDao.delete();
        userDao.find();
        userDao.update();
        userDao.save();
    }

}
