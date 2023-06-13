package com.springcore.springcore.rest;

import com.springcore.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // private field for dependency injection
    private Coach myCoach;
    // setter injection
    @Autowired          // tell Spring to inject a dependency -> 1 dependency @Autowired is optional
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
