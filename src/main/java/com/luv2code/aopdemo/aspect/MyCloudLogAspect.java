package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyCloudLogAspect {

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void performLogToCloudAdvice() {
        System.out.println("===>Perform log to cloud advice");
    }

}
