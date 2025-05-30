package com.springboot.springbootbasicrest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int id;
    private String name;
    private String email;
    private String phone;
}
