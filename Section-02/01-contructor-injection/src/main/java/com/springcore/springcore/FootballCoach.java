package com.springcore.springcore;

import org.springframework.stereotype.Component;

@Component                  // annotation marks the class as Spring bean
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Shooting penalty for 10 times!!!!!!NOW.";
    }
}
