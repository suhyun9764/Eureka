package com.springboot.springbootjpabasiccrudfind.service;

import com.springboot.springbootjpabasiccrudfind.entity.Student;

import java.util.List;

public interface StudentServiceFind{
    List<Student> findByName(String name);
}
