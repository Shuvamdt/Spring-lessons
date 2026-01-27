package com.shuvam.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "Hey! Play tennis for 30 mins";
    }
}
