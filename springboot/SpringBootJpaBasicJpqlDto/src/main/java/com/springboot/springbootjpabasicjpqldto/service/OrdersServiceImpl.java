package com.springboot.springbootjpabasicjpqldto.service;

import com.springboot.springbootjpabasicjpqldto.dto.OrdersDto;
import com.springboot.springbootjpabasicjpqldto.entity.Orders;
import com.springboot.springbootjpabasicjpqldto.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{
    private final OrderRepository orderRepository;

    @Override
    public List<Orders> listOrder() {
        return orderRepository.listOrder();
    }

    @Override
    public List<OrdersDto> listOrdersSeviceDto() {
        List<Orders> ordersList = orderRepository.listOrder();
        List<OrdersDto> ordersDtoList = new ArrayList<>();

        ordersList.forEach(orders -> {
            OrdersDto ordersDto =
                    OrdersDto.builder()
                            .id(orders.getId())
                            .orderQuantity(orders.getOrderQuantity())
                            .orderDate(orders.getOrderDate())
                            .build();
            ordersDtoList.add(ordersDto);
        });

        return ordersDtoList;
    }

    @Override
    public List<OrdersDto> listOrdersRepositoryDto() {
        return orderRepository.listOrdersRepositoryDto();
    }
}
