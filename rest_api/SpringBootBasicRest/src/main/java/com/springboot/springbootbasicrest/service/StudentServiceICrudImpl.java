package com.springboot.springbootbasicrest.service;

import com.springboot.springbootbasicrest.dto.StudentDto;
import com.springboot.springbootbasicrest.dto.StudentResultDto;
import com.springboot.springbootbasicrest.entity.Student;
import com.springboot.springbootbasicrest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceICrudImpl implements StudentServiceCrud {
    private final StudentRepository studentRepository;

    @Override
    public StudentResultDto listStudent() {
        StudentResultDto studentResultDto = new StudentResultDto();
        try {
            List<Student> studentList = studentRepository.findAll();
            List<StudentDto> studentDtoList = new ArrayList<>();
            studentList.forEach(student ->{
                StudentDto studentDto = StudentDto.builder()
                        .email(student.getEmail())
                        .phone(student.getPhone())
                        .name(student.getName())
                        .id(student.getId())
                        .build();
                studentDtoList.add(studentDto);
            });

            studentResultDto.setStudentList(studentDtoList);
            studentResultDto.setResult("success");
        } catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;
    }

    @Override
    public StudentResultDto detailStudent(int id) {
        StudentResultDto studentResultDto = new StudentResultDto();
        try {
            Optional<Student> optionalStudent = studentRepository.findById(id);
            optionalStudent.ifPresentOrElse(
                    student -> {
                        StudentDto studentDto = StudentDto.builder()
                                .email(student.getEmail())
                                .phone(student.getPhone())
                                .name(student.getName())
                                .id(student.getId())
                                .build();
                        studentResultDto.setStudentDto(studentDto);
                        studentResultDto.setResult("success");
                    },
                    ()->{
                        studentResultDto.setResult("notfound");
                    }
            );
        } catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;

    }

    @Override
    public StudentResultDto insertStudent(StudentDto studentDto) {
        StudentResultDto studentResultDto = new StudentResultDto();
        Student student = Student.builder()
                .name(studentDto.getName())
                .phone(studentDto.getPhone())
                .email(studentDto.getEmail())
                .build();
        try {
            studentRepository.save(student);
            studentResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;
    }

    @Override
    public StudentResultDto updateStudent(StudentDto studentDto) {
        // findById 처리 x 버전
        StudentResultDto studentResultDto = new StudentResultDto();
        Student student = Student.builder()
                .name(studentDto.getName())
                .phone(studentDto.getPhone())
                .email(studentDto.getEmail())
                .build();
        try {
            studentRepository.save(student);
            studentResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;
    }

    @Override
    public StudentResultDto deleteStudent(int id) {
        StudentResultDto studentResultDto = new StudentResultDto();
        try {
            studentRepository.deleteById(id);
            studentResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;

    }

    @Override
    public StudentResultDto countStudent() {
        StudentResultDto studentResultDto = new StudentResultDto();
        try {
            long count = studentRepository.count();
            studentResultDto.setCount(count);
            studentResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;
    }

    @Override
    public StudentResultDto listStudent(int pageNumber, int pageSize) {
        StudentResultDto studentResultDto = new StudentResultDto();
        try {
            Pageable pageable = PageRequest.of(pageNumber,pageSize);
            Page<Student> page = studentRepository.findAll(pageable);
            List<Student> studentList = page.toList();

            List<StudentDto> studentDtoList = new ArrayList<>();
            studentList.forEach(student ->{
                StudentDto studentDto = StudentDto.builder()
                        .email(student.getEmail())
                        .phone(student.getPhone())
                        .name(student.getName())
                        .id(student.getId())
                        .build();
                studentDtoList.add(studentDto);
            });

            studentResultDto.setStudentList(studentDtoList);
            studentResultDto.setResult("success");
        } catch (Exception e){
            e.printStackTrace();
            studentResultDto.setResult("fail");
        }
        return studentResultDto;

    }
}
