package com.shuvam.spring_core_demo.rest;

import com.shuvam.spring_core_demo.common.Coach;
import com.shuvam.spring_core_demo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public void setCoach(CricketCoach theCoach){
        myCoach = theCoach;
    }
//    @Autowired
//    public void doStuff(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.dailyWorkout();
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Everyone!";
    }
}
