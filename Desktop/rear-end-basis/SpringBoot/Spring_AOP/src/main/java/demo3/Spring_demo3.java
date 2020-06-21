package demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* demo2包使用spring方式使用动态代理：带有切入点的切面及其属性配置
*/
public class Spring_demo3 {
    @Test
    public void demo1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("demo3.xml");
        UserDao userDao = (UserDao) app.getBean("userDaoProxy");
        userDao.delete();
        userDao.find();
        userDao.update();
        userDao.save();
    }
}
