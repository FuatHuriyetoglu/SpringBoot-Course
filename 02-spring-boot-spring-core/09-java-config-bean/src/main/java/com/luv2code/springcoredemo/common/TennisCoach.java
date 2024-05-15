package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
 class TennisCoach implements Coach {
    public TennisCoach(){
        System.out.println("In constuctor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "practice your backhand volley";
    }
}
