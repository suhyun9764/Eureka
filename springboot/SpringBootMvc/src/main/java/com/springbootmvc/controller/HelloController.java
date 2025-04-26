package com.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // <- handler mapping
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
