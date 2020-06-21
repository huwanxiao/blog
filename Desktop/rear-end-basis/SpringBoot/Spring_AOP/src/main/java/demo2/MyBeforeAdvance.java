package demo2;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class MyBeforeAdvance implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
            System.out.println("权限校验");
    }
}
