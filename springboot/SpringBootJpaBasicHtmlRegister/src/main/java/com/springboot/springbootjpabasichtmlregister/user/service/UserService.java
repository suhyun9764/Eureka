package com.springboot.springbootjpabasichtmlregister.user.service;

import com.springboot.springbootjpabasichtmlregister.user.dto.UserResultDto;
import com.springboot.springbootjpabasichtmlregister.user.entity.User;

public interface UserService {
    UserResultDto insertUser(User user);
}
