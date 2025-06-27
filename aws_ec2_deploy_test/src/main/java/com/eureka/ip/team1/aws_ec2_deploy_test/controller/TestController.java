package com.eureka.ip.team1.aws_ec2_deploy_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello, AWS Deploy";
    }
}
