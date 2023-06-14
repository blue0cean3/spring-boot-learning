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
    private Coach anotherCoach;
    @Autowired
    /*public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }*/
//    can't run because there are 4 beans were found. Required a single bean so use Qualifier
    /* spectify the bean ID in brackets*/
    public DemoController(@Qualifier("volleyballCoach") Coach theCoach,
                          @Qualifier("volleyballCoach")  Coach theAnotherCoach) {
//        with the ID in the bracket the true bean will be run
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        System.out.println("In constructor: " + getClass().getSimpleName());
        return myCoach.getDailyWorkout();
    }
    @GetMapping("check")
    public String check() {
//        Singleton return true: same injection no create new object (will be the same object)
//        Prototype return false: new object will create for each injection
        return "Comparing beans myCoach = anotherCoach: " + (myCoach == anotherCoach);
    }

}
