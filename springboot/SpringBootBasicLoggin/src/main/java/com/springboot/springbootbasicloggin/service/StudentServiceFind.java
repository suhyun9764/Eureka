package com.springboot.springbootbasicloggin.service;

import com.springboot.springbootbasicloggin.entity.Student;

import java.util.List;

public interface StudentServiceFind{
    List<Student> findByName(String name);
}
