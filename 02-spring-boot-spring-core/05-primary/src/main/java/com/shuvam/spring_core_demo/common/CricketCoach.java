package com.shuvam.spring_core_demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{

    @Override
    public String dailyWorkout() {
        return "Hey! Play cricket for 1 hrs";
    }
}
