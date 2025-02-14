package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // optional for only pointcut expressions, add for potentially adding advices later
public class AopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")  // match any package/method/number of parameters
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")  // match setters
    public void setters() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")  // match getters
    public void getters() {
    }

    @Pointcut("forDaoPackage() && !(setters() || getters())")  // match package exclude setters and getters
    public void forDaoPackageWithoutGettersAndSetters() {
    }
}
