package com.springboot.springbootjpabasiccrudfind.service;

import com.springboot.springbootjpabasiccrudfind.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentServiceCrud {
    List<Student> listStudent();
    Optional<Student> detailStudent(int id);

    Student insertStudent(Student student); // jpa 를 이용해서 table에 insert하고 영속화 시킨 객체를 return
    Optional<Student> updateStudent(Student student);
    void deleteStudent(int id); // delete는 return이 void
    long countStudent();
    List<Student> listStudent(int pageNumber, int pageSize);
}
