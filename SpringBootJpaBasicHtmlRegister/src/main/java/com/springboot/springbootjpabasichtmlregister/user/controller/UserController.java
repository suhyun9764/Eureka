package com.springboot.springbootjpabasichtmlregister.user.controller;

import com.springboot.springbootjpabasichtmlregister.user.dto.UserDto;
import com.springboot.springbootjpabasichtmlregister.user.dto.UserResultDto;
import com.springboot.springbootjpabasichtmlregister.user.entity.User;
import com.springboot.springbootjpabasichtmlregister.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResultDto insertUser(User user){
        return userService.insertUser(user);
    }
}
