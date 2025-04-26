package com.mycom.myapp.auth.service;

import com.mycom.myapp.user.dto.UserDto;

import java.util.Optional;

// loginResultDto를 만들지 않고 UserDto를 return 하는 이유는 Controller에서 session처리를 하고 난 뒤에 front에 응답
public interface LoginService {
    Optional<UserDto> login(UserDto userDto);
}
