package com.springboot.springbootsecurity_4.user.controller;

import com.springboot.springbootsecurity_4.user.dto.UserDto;
import com.springboot.springbootsecurity_4.user.dto.UserResultDto;
import com.springboot.springbootsecurity_4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResultDto insertUser(UserDto userDto){
        System.out.println("/users");
        return userService.insertUser(userDto);
    }
}
