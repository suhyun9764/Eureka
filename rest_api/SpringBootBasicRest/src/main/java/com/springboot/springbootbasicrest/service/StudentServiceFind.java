package com.springboot.springbootbasicrest.service;


import com.springboot.springbootbasicrest.entity.Student;

import java.util.List;

public interface StudentServiceFind{
    List<Student> findByName(String name);
}
