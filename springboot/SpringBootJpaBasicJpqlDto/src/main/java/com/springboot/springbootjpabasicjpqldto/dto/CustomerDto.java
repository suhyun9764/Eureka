package com.springboot.springbootjpabasicjpqldto.dto;

import java.util.List;

import com.springboot.springbootjpabasicjpqldto.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor // jpql 에서 사용할 예정
public class CustomerDto {
    private int id;
    private String name;
    private char gender;
    private String phone;
    private List<Orders> orders;
}

