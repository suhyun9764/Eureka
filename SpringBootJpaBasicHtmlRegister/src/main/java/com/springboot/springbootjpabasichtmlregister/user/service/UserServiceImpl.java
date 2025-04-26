package com.springboot.springbootjpabasichtmlregister.user.service;

import com.springboot.springbootjpabasichtmlregister.user.dto.UserResultDto;
import com.springboot.springbootjpabasichtmlregister.user.entity.User;
import com.springboot.springbootjpabasichtmlregister.user.entity.UserRole;
import com.springboot.springbootjpabasichtmlregister.user.repository.UserRepository;
import com.springboot.springbootjpabasichtmlregister.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserResultDto insertUser(User user) {
        // #1. 기존 UserRole 을 find, name
        UserResultDto userResultDto = new UserResultDto();
//        UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
//        List<UserRole> userRoles = List.of(userRole);
//        user.setUserRoles(userRoles);
//        User savedUser = userRepository.save(user);


        // #2. 새로운 userrole생성

        // #2-1. userROle 객체 save x -> 영속화 x
//        UserRole userRole = new UserRole();
//        userRole.setName("role-_test");
//        List<UserRole> userRoles = List.of(userRole);
//        user.setUserRoles(userRoles);
//        User savedUser = userRepository.save(user);

        // #2-2. userROle 객체 save o -> 영속화 o
//        UserRole userRole = new UserRole();
//        userRole.setName("role-_test2");
//        List<UserRole> userRoles = List.of(userRole);
//        user.setUserRoles(userRoles);
//        userRoleRepository.save(userRole);
//        User savedUser = userRepository.save(user);
//        userResultDto.setResult("success");
//        return userResultDto;
        // #3. transactional + #1 상황
//                UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
//        List<UserRole> userRoles = List.of(userRole);
//        user.setUserRoles(userRoles);
//        User savedUser = userRepository.save(user);
//
//        System.out.println(savedUser);
//
//        String s = null;
//        s.length();

        // #3. transactional + #2-2 상황
                UserRole userRole = userRoleRepository.findByName("ROLE_CUSTOMER");
        List<UserRole> userRoles = List.of(userRole);
        user.setUserRoles(userRoles);
        User savedUser = userRepository.save(user);

        System.out.println(savedUser);

        String s = null;
        s.length();

        return userResultDto;
    }
}
