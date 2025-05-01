package com.springboot.springbootbasicloggin.service;

import com.springboot.springbootbasicloggin.entity.Student;
import com.springboot.springbootbasicloggin.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceFindImpl implements StudentServiceFind{
    private final StudentRepository studentRepository;
    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
