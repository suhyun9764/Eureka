package com.springboot.springbootbasicloggin.controller;

import com.springboot.springbootbasicloggin.dto.StudentDto;
import com.springboot.springbootbasicloggin.dto.StudentResultDto;
import com.springboot.springbootbasicloggin.service.StudentServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// REST를 적용하면 /api/
// get list : /students
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/json")
public class StudentControllerJsonRequest {
    private final StudentServiceCrud studentService;

    @GetMapping("/students")
    public StudentResultDto listStudent(){
        return studentService.listStudent();
    }

    @GetMapping("/students/{id}")
    public StudentResultDto detailStudent(@PathVariable("id") int id){
        return studentService.detailStudent(id);
    }

    // 등록, 수정에 사용되는 StudentDto를 Client에서 Json으로 보낸다.
    @PostMapping("/students")
    public StudentResultDto insertStudent(@RequestBody StudentDto studentDto){
        return studentService.insertStudent(studentDto);
    }

    @PutMapping("/students/{id}")
    public StudentResultDto updateStudent(@PathVariable("id") int id, @RequestBody StudentDto studentDto){
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
