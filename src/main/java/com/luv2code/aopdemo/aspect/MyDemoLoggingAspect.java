package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // here are all the advices for logging

    // WHEN USING * LIMIT RANGE TO PROJECT PACKAGE, NARROW POINT CUT EXPRESSION


    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")  // match any package/method/number of parameters
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")  // match setters
    private void setters() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")  // match getters
    private void getters() {
    }

    @Pointcut("forDaoPackage() && !(setters() || getters())")  // match package exclude setters and getters
    private void forDaoPackageWithoutGettersAndSetters() {
    }

//    @Before("execution(public void addAccount())") // match any class
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // match specific interface/implementation
//    @Before("execution(public void add*())")  // match any method starting with add
//    @Before("execution(* add*(com.luv2code.aopdemo.Account))")  // match specific parameter
//    @Before("execution(* com.luv2code.aopdemo.dao.*.add*(*))")  // match package and any one parameter
//    @Before("execution(* com.luv2code.aopdemo.dao.*.add*(..))")  // match package and any number of parameters
//    @Before("forDaoPackage()")
    @Before("forDaoPackageWithoutGettersAndSetters()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n===>Executing @Before advice on method");
    }

    @After("forDaoPackage()")
    public void afterAddAccountAdvice() {

        System.out.println("===>Executing @After advice on method\n");
    }

}
