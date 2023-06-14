package com.springcore.springcore.rest;

import com.springcore.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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
//    Baseball have @Primary so baseball will run
//    Note: @Qualifier have higher priority than @Primary. No multip @Primary
    public DemoController(/*@Qualifier("tennisCoach"*/ /* spectify the bean ID in brackets*/Coach theCoach) {
//        with the ID in the bracket the true bean will be run
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
