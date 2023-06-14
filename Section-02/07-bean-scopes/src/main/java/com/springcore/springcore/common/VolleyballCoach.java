package com.springcore.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.module.Configuration;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
