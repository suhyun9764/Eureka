package com.springboot.springbootbasicrest.controller;

import com.springboot.springbootbasicrest.entity.Student;
import com.springboot.springbootbasicrest.service.StudentServiceFind;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentFind {
    private final StudentServiceFind studentService;

    @GetMapping("/find/name")
    public List<Student> findByName(@RequestParam("name") String name){
        return studentService.findByName(name);
    }


}
