package com.springboot.springbootbasicjunit5.user.service;


import com.springboot.springbootbasicjunit5.user.dto.UserResultDto;
import com.springboot.springbootbasicjunit5.user.entity.User;

public interface UserService {
    UserResultDto insertUser(User user);
}
