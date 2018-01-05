package com.learning.spring_performance;

import org.springframework.stereotype.Component;

@Component
public class Person {

    
    public String getName() {
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Raj";
    }
}
