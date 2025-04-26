package com.mycom.myapp.auth.service;

import com.mycom.myapp.auth.dao.LoginDao;
import com.mycom.myapp.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Optional<UserDto> login(UserDto userDto) {
        UserDto dto = loginDao.login(userDto.getUserEmail());
        if(dto != null && userDto.getUserPassword().equals(dto.getUserPassword()))  return Optional.ofNullable(dto);
        return Optional.empty();
    }
}
