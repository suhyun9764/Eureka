package com.springboot.springbootbasicjunit5.user.repository;


import com.springboot.springbootbasicjunit5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // login
//    Optional<User> findByEmail(String email);

    // JPQL
    @Query("select u from User u join fetch u.userRoles where u.email = :email")
    Optional<User> findByEmail(@Param("email")String email);
}
