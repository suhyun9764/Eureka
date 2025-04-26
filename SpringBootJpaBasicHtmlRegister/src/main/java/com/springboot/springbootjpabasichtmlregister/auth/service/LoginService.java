package com.springboot.springbootjpabasichtmlregister.auth.service;


import com.springboot.springbootjpabasichtmlregister.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
