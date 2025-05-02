package com.springboot.springbootsecurity_2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    // DI
    private final PasswordEncoder passwordEncoder;


    // 기본 form ui 로그인 그대로
    // username, password가 user/ console password 사용 x<= UserDetailService를 제공하므로
    // form ui에 사용자가 입력한 username 값이 loadUserByUsername() 파라미터로 전달(username)
    // DB를 통해서 (JPA 경우 UserRepository를 거쳐서) username으로 select username,password를 가져와서
    // UserDetails 구현 객체를 만들어서 return 해줘야 한다.
    // UserDetails 구현 객체는 우선 Spring Security에서 제공하는 import org.springframework.security.core.userdetails.User; 사용
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       // PasswordEncoder 객체 구현 크래스
//        System.out.println(passwordEncoder.getClass());
//        if("shShin".equals(username)){
//            return User.builder()
//                    .username("shShin")
//                    .password(passwordEncoder.encode("1234"))
//                    .build();
//        }else {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // PasswordEncoder 객체 구현 크래스
        System.out.println(passwordEncoder.getClass());
        if("shShin".equals(username)){
            return User.builder()
                    .username("shShin")
                    .password(passwordEncoder.encode("1234"))
                    .authorities("ADMIN")
                    .build();
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
