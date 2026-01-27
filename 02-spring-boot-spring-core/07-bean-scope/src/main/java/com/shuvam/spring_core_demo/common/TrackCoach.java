package com.shuvam.spring_core_demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "Hey! Run 5km";
    }
}
