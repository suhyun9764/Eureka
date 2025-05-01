package com.springboot.springbootbasicloggin.controller;

import com.springboot.springbootbasicloggin.entity.Student;
import com.springboot.springbootbasicloggin.service.StudentServiceFind;
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
