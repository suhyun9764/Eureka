package com.springboot.springbootjpabasichtmllogin.auth.service;

import com.springboot.springbootjpabasichtmllogin.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
