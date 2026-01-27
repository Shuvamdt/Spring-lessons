package com.shuvam.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "Hey! Run 5km";
    }
}
