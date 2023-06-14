package com.springcore.springcore.rest;

import com.springcore.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // constructor injection
    private Coach myCoach;
    @Autowired
//    SwimCoach did not @Component so it's fail to run.
//    We use @Configuration in a new Config class to config it as a Spring Bean using @Bean
//    @Bean use to take existing 3rd party class to expose as a Spring Bean
//    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
//        myCoach = theCoach;
//    }
//    use "aqua" which is new id for swimCoach to expose
        public DemoController(@Qualifier("aqua") Coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
