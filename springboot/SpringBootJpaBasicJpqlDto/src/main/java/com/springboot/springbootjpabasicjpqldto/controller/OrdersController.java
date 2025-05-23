package com.springboot.springbootjpabasicjpqldto.controller;

import com.springboot.springbootjpabasicjpqldto.dto.OrdersDto;
import com.springboot.springbootjpabasicjpqldto.entity.Orders;
import com.springboot.springbootjpabasicjpqldto.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    // #0
    // Controller 에서 Entity 를 JSON 변환, 응답
//	@GetMapping("/listorders")
//	public List<Orders> listOrders() {
//		return ordersService.listOrder();
//	}

    // #1
    // Controller 에서 Entity -> DTO 변경 후, DTO 를 JSON 으로 변환, 응답
//	@GetMapping("/listorders")
//	public List<OrdersDto> listOrders() {
//		List<Orders> ordersList =  ordersService.listOrder();
//		List<OrdersDto> ordersDtoList = new ArrayList<>();
//
//		ordersList.forEach(orders -> {
//			OrdersDto ordersDto =
//					OrdersDto.builder()
//					.id(orders.getId())
//					.orderQuantity(orders.getOrderQuantity())
//					.orderDate(orders.getOrderDate())
//					.build();
//			ordersDtoList.add(ordersDto);
//		});
//
//		return ordersDtoList;
//	}


    // #2
    // Service 에서 Entity -> DTO 변경 후, DTO 를 JSON 으로 변환, 응답
//		@GetMapping("/listordersservicedto")
//		public List<OrdersDto> listOrders() {
//			return ordersService.listOrdersSeviceDto();
//		}

    // #3
    // Service 에서 Entity -> DTO 변경 후, DTO 를 JSON 으로 변환, 응답
    @GetMapping("/listordersrepositorydto")
    public List<OrdersDto> listOrders() {
        return ordersService.listOrdersRepositoryDto();
    }

}