package com.springboot.springbootjpabasicjpqldto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class OrdersCustomerDto {
	private int orderId;
	private String customerName;
	private String customerPhone;
	private LocalDate orderDate;
}