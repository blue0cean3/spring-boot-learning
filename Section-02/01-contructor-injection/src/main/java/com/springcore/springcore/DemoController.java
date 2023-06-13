package com.springcore.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // private field for dependency injection
    private Coach myCoach;
    // constructor for dependency injection
    @Autowired          // tell Spring to inject a dependency -> 1 dependency @Autowired is optional
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
