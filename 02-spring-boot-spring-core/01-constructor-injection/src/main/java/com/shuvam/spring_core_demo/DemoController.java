package com.shuvam.spring_core_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private CricketCoach myCoach;

    @Autowired
    public DemoController(CricketCoach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.dailyWorkout();
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Everyone!";
    }
}
