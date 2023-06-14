package com.springcore.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
// primary will be the one which is run
@Primary
@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Batting practice in 30 minutes";
    }
}
