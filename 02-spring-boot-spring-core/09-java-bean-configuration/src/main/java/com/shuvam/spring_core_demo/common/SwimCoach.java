package com.shuvam.spring_core_demo.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In cons of :"+ getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "Swim a 1000m as a warm up";
    }
}
