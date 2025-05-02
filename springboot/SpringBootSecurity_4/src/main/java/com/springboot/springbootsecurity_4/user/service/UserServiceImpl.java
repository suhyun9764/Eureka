package com.springboot.springbootsecurity_4.user.service;

import com.springboot.springbootsecurity_4.user.dto.UserDto;
import com.springboot.springbootsecurity_4.user.dto.UserResultDto;
import com.springboot.springbootsecurity_4.user.entity.User;
import com.springboot.springbootsecurity_4.user.entity.UserRole;
import com.springboot.springbootsecurity_4.user.repository.UserRepository;
import com.springboot.springbootsecurity_4.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResultDto insertUser(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();

        try {
            Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

            if( optionalUser.isPresent()  ) {
                userResultDto.setResult("exist");
                return userResultDto;
            }
            List<UserRole> userRoles = List.of(userRoleRepository.findByName("CUSTOMER")); // Spring Security 에서 Role 을 "Granted Authorities" 이름으로 저장하는데 자동으로 ROLE_ 를 붙인다.

            User user = new User();

            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            user.setPassword(encodedPassword);

            user.setUserRoles(userRoles); // User 와 UserRole 연결
            User savedUser = userRepository.save(user);
            userResultDto.setResult("success");

        }catch( Exception e ) {
            e.printStackTrace();
            userResultDto.setResult("fail");
        }

        return userResultDto;
    }
}
