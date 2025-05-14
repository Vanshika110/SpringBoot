package com.vanshii.spring.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/addtwonum")
    public int addtwonum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/multwonum")
    public int multwonum(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }
}
