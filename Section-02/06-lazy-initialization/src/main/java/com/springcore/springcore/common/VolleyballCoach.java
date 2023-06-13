package com.springcore.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {
    public VolleyballCoach() {
        //check which one will run
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice serving.";
    }
}
