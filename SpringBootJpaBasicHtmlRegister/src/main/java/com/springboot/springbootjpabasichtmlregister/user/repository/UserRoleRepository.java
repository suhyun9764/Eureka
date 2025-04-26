package com.springboot.springbootjpabasichtmlregister.user.repository;

import com.springboot.springbootjpabasichtmlregister.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    UserRole findByName(String name);
}
