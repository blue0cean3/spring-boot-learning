package com.springcore.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach {
    public VolleyballCoach() {
        //check which one will run
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

//    init method
    @PostConstruct
    public void doStartup() {
        System.out.println("In doStartup(), we init: " + getClass().getSimpleName());
    }

//    destroy method
    @PreDestroy
    public void doCleanup() {
        System.out.println("In doCleanuo(), we clean: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice serving.";
    }
}
