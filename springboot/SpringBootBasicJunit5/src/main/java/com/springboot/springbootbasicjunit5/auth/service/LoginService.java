package com.springboot.springbootbasicjunit5.auth.service;

import com.springboot.springbootbasicjunit5.user.dto.UserResultDto;

public interface LoginService {
    UserResultDto login(String email, String password);
}
