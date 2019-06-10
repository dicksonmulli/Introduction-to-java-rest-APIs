package com.hello.application.controller;

import com.hello.application.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class GreetingController {

    private static final String template = "Hello, %s!!!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greet(@RequestParam(value="name", defaultValue="World") String name) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return "Hello";
    }

    @PostMapping("/greetings")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
