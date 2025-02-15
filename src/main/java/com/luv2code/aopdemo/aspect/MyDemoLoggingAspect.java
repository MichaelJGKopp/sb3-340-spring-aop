package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(2)
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
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("===>Perform logging demo aspect");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Arg: " + arg);

            if (arg instanceof Account account) {
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(    // if value is returned, no exception
            pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()",
            returning = "result")
    public void afterReturningAddAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature()
//                .toLongString();
//                .toString();
                .toShortString();
        System.out.println("===>Perform @AfterReturning in logging demo aspect on: " + method);

        // modify the return value, careful to communicate this with your team
        if (!result.isEmpty()) {

            // change the account name of the first entry
            result.getFirst().setName("Changed Name");

            // convert account names to uppercase
            for (Account a : result) {
                a.setName(a.getName().toUpperCase());
            }
        }

        System.out.println("Return value List<Account>: ");
        result.forEach(System.out::println);
    }

    @AfterThrowing( // after an exception is thrown
            pointcut="com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()",
            throwing="exception")
    public void afterThrowingAddAccountAdvice(JoinPoint joinPoint, Throwable exception) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("===>Perform @AfterThrowing in MyLoggingDemoAspect on: " + method + "\n"
                + "exception: " + exception);
    }

    @After("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageWithoutGettersAndSetters()")
    public void afterAddAccountAdvice() {

        System.out.println("===>Executing @After advice on method\n");
    }
}
