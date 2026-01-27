package com.shuvam.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String dailyWorkout() {
        return "Hey! Play Baseball for 20 mins";
    }
}
