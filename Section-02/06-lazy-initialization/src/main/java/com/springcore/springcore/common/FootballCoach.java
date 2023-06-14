package com.springcore.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component                  // annotation marks the class as Spring bean
public class FootballCoach implements Coach {
    public FootballCoach() {
        //check which one will run
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Shooting penalty for 10 times!!!!!!NOW. :)";
    }
}
