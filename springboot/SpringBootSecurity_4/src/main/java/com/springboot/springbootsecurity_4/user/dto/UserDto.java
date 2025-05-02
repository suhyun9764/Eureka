package com.springboot.springbootsecurity_4.user.dto;

import com.springboot.springbootsecurity_4.user.entity.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private List<UserRole> roles;
}
