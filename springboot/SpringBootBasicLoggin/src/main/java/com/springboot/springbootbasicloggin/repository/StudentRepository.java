package com.springboot.springbootbasicloggin.repository;

import com.springboot.springbootbasicloggin.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// repository 역할을 담당하는 구현 코드를 Spring Data Jpa가 대신 생성, 수행
// extends JpaRepository  코드에 의해
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // sql : 다양한 select
    // 표현을 잘 하면 자동으로 jpql을 만들어 줄께
    List<Student> findByName(String name);
}
