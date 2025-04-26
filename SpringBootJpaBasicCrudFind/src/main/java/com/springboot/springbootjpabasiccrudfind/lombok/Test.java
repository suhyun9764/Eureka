package com.springboot.springbootjpabasiccrudfind.lombok;

public class Test {
    public static void main(String[] args) {
        EmpDto2 empDto2 = EmpDto2.builder()
                .employeeId(1)
                .firstName("길동")
                .lastName("홍")
                .email("hong@gildong.com")
                .departmentId("123")
                .hireDate("2025-04-22")
                .build();

        System.out.println(empDto2);
        empDto2.getEmployeeId();
    }
}
