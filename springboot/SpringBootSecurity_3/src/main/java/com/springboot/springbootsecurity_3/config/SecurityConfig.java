package com.springboot.springbootsecurity_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        request -> {
                            request.requestMatchers("/","/index.html").permitAll()
                                    .requestMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
                                    .requestMatchers("/admin/**").hasRole("ADMIN")
                                    .anyRequest().authenticated();
                        })
                .formLogin(form ->form.defaultSuccessUrl(
                        "/",true)
                        .permitAll()
                )
                .logout(logout->logout.permitAll()) // /logout url로 요청하면 자동으로 Spring Security가 자동으로 session을 invalidate
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
