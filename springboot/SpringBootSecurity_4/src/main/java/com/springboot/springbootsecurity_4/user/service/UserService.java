package com.springboot.springbootsecurity_4.user.service;


import com.springboot.springbootsecurity_4.user.dto.UserDto;
import com.springboot.springbootsecurity_4.user.dto.UserResultDto;

public interface UserService {
    UserResultDto insertUser(UserDto userDto);
}
