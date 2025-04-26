package com.springboot.springbootjpabasiccrudfind.controller;

import com.springboot.springbootjpabasiccrudfind.entity.Student;
import com.springboot.springbootjpabasiccrudfind.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// return type이 Student(Entity)인데, StudentDto를 사용하는게 바람직하다. 단순화 하기 위한 코드
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceCrud studentService;

    @GetMapping("/list")
    public List<Student> listStudent(){
        return studentService.listStudent();
    }

    @GetMapping("/detail/{id}")
    public Optional<Student> detailStudent(@PathVariable("id") int id){
        return studentService.detailStudent(id);
    }

    @PostMapping("/insert")
    public Student insertStudent(Student student){
        return studentService.insertStudent(student);
    }

    @PostMapping("/update")
    public Optional<Student> updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/count")
    public Long countStudent(){
        return studentService.countStudent();
    }

    @GetMapping("/page")
    public List<Student> listStudent(@RequestParam("pageNumber") Integer pageNumber,
                                     @RequestParam("pageSize") Integer pageSize){
        return studentService.listStudent(pageNumber,pageSize);
    }


}
