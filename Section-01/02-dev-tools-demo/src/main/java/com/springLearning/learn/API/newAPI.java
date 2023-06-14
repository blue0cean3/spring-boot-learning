package com.springLearning.learn.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newAPI {
//    expose "/" that return hello function
    @GetMapping("/")
    public String hello() {
        return "Hello motherfucker";
    }
//    expose endpoint for lmao
    @GetMapping("/lmao")
    public String lmao() {
        return "LMAO EZ!";
    }
//    expose endpoint for ez
    @GetMapping("/ez")
    public String ez() {
        return "EZ!";
    }
}
