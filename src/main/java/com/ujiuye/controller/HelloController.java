package com.ujiuye.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(){

        System.out.println("sa");
        return  "hello ujiuye";
    }

    @PostMapping("/add")
    public  void add(){
        System.out.println("add");
    }



}
