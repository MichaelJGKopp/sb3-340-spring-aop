package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyAPIAnalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void performAPIAnalyticsAdvice() {
        System.out.println("===>Perform API analytics advice");
    }

}
