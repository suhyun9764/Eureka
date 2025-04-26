package com.springboot.springbootjpabasichtmllogin.auth.service;

import com.springboot.springbootjpabasichtmllogin.user.dto.UserDto;
import com.springboot.springbootjpabasichtmllogin.user.dto.UserResultDto;
import com.springboot.springbootjpabasichtmllogin.user.entity.User;
import com.springboot.springbootjpabasichtmllogin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService{
    private final UserRepository userRepository;

    @Override
    public UserResultDto login(String email, String password) {
        UserResultDto userResultDto = new UserResultDto();
        log.debug("login() 시작");

        Optional<User> optionalUser = userRepository.findByEmail(email);

//        Optional<User> optionalUser = userRepository.findById(4L);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(password)){
                // User -> UserDto
                // UserRole도 같이

                Map<Integer,String> roles = new HashMap<>();
                user.getUserRoles().forEach(userRole -> roles.put(userRole.getId(),userRole.getName()));
                UserDto userDto = UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .roles(roles)
                        .build();

                userResultDto.setResult("success");
                userResultDto.setUserDto(userDto);
            }else{
                userResultDto.setResult("fail");
            }
        }else {
            userResultDto.setResult("fail");
        }

        log.debug("login() 종료");
        return userResultDto;
    }
}
