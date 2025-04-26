package com.springboot.springbootjpabasiccrudfind.service;

import com.springboot.springbootjpabasiccrudfind.entity.Student;
import com.springboot.springbootjpabasiccrudfind.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceICrudImpl implements StudentServiceCrud {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> detailStudent(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> updateStudent(Student student) {
        // 수정 작업일 때, Student 타입으로 return 할경우
//        return studentRepository.save(student);

        // Optional<Student> 타입으로 return할 경우
        Optional<Student> existingStudent = studentRepository.findById(student.getId());
        if(existingStudent.isPresent()){
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public long countStudent() {
        return studentRepository.count();
    }

    @Override
    public List<Student> listStudent(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Student> page = studentRepository.findAll(pageable);
        return page.toList();
    }
}
