package com.shuvam.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String dailyWorkout() {
        return "Hey! Run 5km!";
    }
}
