package com.springcore.springcore.rest;

import com.springcore.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // constructor injection
    private Coach myCoach;
    @Autowired
    /*public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }*/
//    can't run because there are 4 beans were found. Required a single bean so use Qualifier
    /* spectify the bean ID in brackets*/
    public DemoController(@Qualifier("volleyballCoach") Coach theCoach) {
//        with the ID in the bracket the true bean will be run
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
