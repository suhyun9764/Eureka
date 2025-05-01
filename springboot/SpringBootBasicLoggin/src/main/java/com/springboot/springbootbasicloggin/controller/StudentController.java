package com.springboot.springbootbasicloggin.controller;


import com.springboot.springbootbasicloggin.dto.StudentDto;
import com.springboot.springbootbasicloggin.dto.StudentResultDto;
import com.springboot.springbootbasicloggin.service.StudentServiceCrud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

// REST를 적용하면 /api/
// get list : /students
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
@Tag(name= "기본 Student CRUD API", description = "student의 등록,수정,삭제, 목록 조회, 상세 조회 기능을 REST API로 제공합니다")
public class StudentController {
    private final StudentServiceCrud studentService;

    @Operation(summary = "학생 목록 조회", description = "전체 학생 목록을 조회합니다")
    @GetMapping("/students")
    public StudentResultDto listStudent(){
        log.debug("listStudent() debug");
        log.info("listStudent() info");
        log.warn("listStudent() warn");
        return studentService.listStudent();
    }

    @Operation(summary = "학생 상세 조회", description = "개별 학생을 조회합니다", deprecated = true)
    @GetMapping("/students/{id}")
    public StudentResultDto detailStudent(@PathVariable("id") int id){
        return studentService.detailStudent(id);
    }

    @Operation(summary = "학생 등록", description = "신규 학생을 등록합니다", hidden = true)
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
