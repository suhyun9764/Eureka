package com.springboot.springbootjpabasichtmllogin.user.dto;

import com.springboot.springbootjpabasichtmllogin.user.entity.UserRole;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    private Map<Integer,String> roles;
}
