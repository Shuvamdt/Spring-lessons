package com.shuvam.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Hey! Play tennis for 30 mins";
    }
}
