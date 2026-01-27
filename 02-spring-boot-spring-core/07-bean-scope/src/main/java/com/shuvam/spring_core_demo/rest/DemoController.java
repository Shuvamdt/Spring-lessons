package com.shuvam.spring_core_demo.rest;

import com.shuvam.spring_core_demo.common.Coach;
import com.shuvam.spring_core_demo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoah;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach, @Qualifier("trackCoach") Coach theAnotherCoach){
        myCoach = theCoach;
        anotherCoah = theAnotherCoach;
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

    @GetMapping("/check")
    public String check(){
        return myCoach == anotherCoah ? "They are equal" : "They are not equal";
    }
}
