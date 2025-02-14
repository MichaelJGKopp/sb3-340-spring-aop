package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // here are all the advices for logging

//    @Before("execution(public void addAccount())") // match any class
    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // match specific interface/implementation
    public void beforeAddAccountAdvice() {

        System.out.println("\n===>Executing @Before advice on method");
    }
}
