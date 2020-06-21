package demo3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroudAdvace implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = methodInvocation.proceed();
        System.out.println("环绕后增强");  
        return proceed;
    }
}
