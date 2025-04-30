package com.springboot.springbootbasicjunit5.user.controller;

import com.springboot.springbootbasicjunit5.user.dto.UserResultDto;
import com.springboot.springbootbasicjunit5.user.entity.User;
import com.springboot.springbootbasicjunit5.user.service.UserService;
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
