package com.springboot.springbootjpabasicjpqldto.service;

import com.springboot.springbootjpabasicjpqldto.dto.OrdersDto;
import com.springboot.springbootjpabasicjpqldto.entity.Orders;

import java.util.List;


public interface OrdersService {

    // #0, #1
    List<Orders> listOrder();

    // #2
    List<OrdersDto> listOrdersSeviceDto();

    // #3
    List<OrdersDto> listOrdersRepositoryDto();
}