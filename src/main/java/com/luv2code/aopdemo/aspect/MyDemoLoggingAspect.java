package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyDemoLoggingAspect {

    // here are all the advices for logging

    // WHEN USING * LIMIT RANGE TO PROJECT PACKAGE, NARROW POINT CUT EXPRESSION

//    @Before("execution(public void addAccount())") // match any class
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // match specific interface/implementation
//    @Before("execution(public void add*())")  // match any method starting with add
//    @Before("execution(* add*(com.luv2code.aopdemo.Account))")  // match specific parameter
//    @Before("execution(* com.luv2code.aopdemo.dao.*.add*(*))")  // match package and any one parameter
//    @Before("execution(* com.luv2code.aopdemo.dao.*.add*(..))")  // match package and any number of parameters
//    @Before("forDaoPackage()")
    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void beforeAddAccountAdvice() {

        System.out.println("===>Perform logging demo aspect");
    }

    @After("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void afterAddAccountAdvice() {

        System.out.println("===>Executing @After advice on method\n");
    }

}
