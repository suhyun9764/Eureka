package com.springboot.springbootbasicrest.controller;

import com.springboot.springbootbasicrest.dto.StudentDto;
import com.springboot.springbootbasicrest.dto.StudentResultDto;
import com.springboot.springbootbasicrest.entity.Student;
import com.springboot.springbootbasicrest.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// REST를 적용하면 /api/
// get list : /students
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {
    private final StudentServiceCrud studentService;

    @GetMapping("/students")
    public StudentResultDto listStudent(){
        return studentService.listStudent();
    }

    @GetMapping("/students/{id}")
    public StudentResultDto detailStudent(@PathVariable("id") int id){
        return studentService.detailStudent(id);
    }

    @PostMapping("/students")
    public StudentResultDto insertStudent(StudentDto studentDto){
        return studentService.insertStudent(studentDto);
    }

    @PutMapping("/students/{id}")
    public StudentResultDto updateStudent(@PathVariable("id") int id, StudentDto studentDto){
        studentDto.setId(id);
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/students/{id}")
    public StudentResultDto deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/students/count")
    public StudentResultDto countStudent(){
        return studentService.countStudent();
    }

    @GetMapping("/students/page")
    public StudentResultDto listStudent(@RequestParam("pageNumber") Integer pageNumber,
                                     @RequestParam("pageSize") Integer pageSize){
        return studentService.listStudent(pageNumber,pageSize);
    }


}
