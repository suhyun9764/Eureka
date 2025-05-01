package com.springboot.springbootbasicloggin.service;


import com.springboot.springbootbasicloggin.dto.StudentDto;
import com.springboot.springbootbasicloggin.dto.StudentResultDto;

public interface StudentServiceCrud {
    StudentResultDto listStudent();
    StudentResultDto detailStudent(int id);

    StudentResultDto insertStudent(StudentDto studentDto); // jpa 를 이용해서 table에 insert하고 영속화 시킨 객체를 return
    StudentResultDto updateStudent(StudentDto studentDto);
    StudentResultDto deleteStudent(int id); // delete는 return이 void
    StudentResultDto countStudent();
    StudentResultDto listStudent(int pageNumber, int pageSize);
}
