package com.springboot.springbootsecurity_4.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResultDto {
    private String result;
    private UserDto userDto;
    private List<UserDto> userList;
}
