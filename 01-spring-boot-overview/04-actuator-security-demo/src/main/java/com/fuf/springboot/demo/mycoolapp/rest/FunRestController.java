package com.fuf.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!!";

    }

// expose a new endpoint for "workout "

@GetMapping("/workout")
    public String getDailyWorkout (){
        return "Run a hard 5k!";
}
    @GetMapping("/fortune")
    public String getDailyFortune (){
        return "Today is your lucky day.";

    }

    @GetMapping("/adam")
    public String getTheAdam(){
        return "selamın aleyküm adım azrail";
    }
}
