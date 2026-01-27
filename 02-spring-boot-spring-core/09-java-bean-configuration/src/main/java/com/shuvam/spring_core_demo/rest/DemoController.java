package com.shuvam.spring_core_demo.rest;

import com.shuvam.spring_core_demo.common.Coach;
import com.shuvam.spring_core_demo.common.CricketCoach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        myCoach = theCoach;
        System.out.println(getClass().getSimpleName());
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
