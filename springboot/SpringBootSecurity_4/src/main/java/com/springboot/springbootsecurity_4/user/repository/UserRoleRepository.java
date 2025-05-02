package com.springboot.springbootsecurity_4.user.repository;

import com.springboot.springbootsecurity_4.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    UserRole findByName(String name);
}
