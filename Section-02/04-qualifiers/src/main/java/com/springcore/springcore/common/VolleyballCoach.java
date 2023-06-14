package com.springcore.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice serving.";
    }
}
