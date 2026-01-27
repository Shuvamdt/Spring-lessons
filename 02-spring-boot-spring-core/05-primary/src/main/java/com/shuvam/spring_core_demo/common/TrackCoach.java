package com.shuvam.spring_core_demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "Hey! Run 5km";
    }
}
