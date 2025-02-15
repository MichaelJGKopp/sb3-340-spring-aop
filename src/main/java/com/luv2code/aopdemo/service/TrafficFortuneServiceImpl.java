package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune(boolean throwException) {

        // simulate a delay
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if (throwException) {
            throw new RuntimeException("Test @Around exception handling");
        }

        // return a fortune
        return "It's your lucky day!";
    }
}
