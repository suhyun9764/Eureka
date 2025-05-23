package com.springboot.springbootbasicloggin.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/auth/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession httpSession
    ){
        httpSession.setAttribute("username",username);
        return """
                {"result":"success"}
                """;
    }
}
