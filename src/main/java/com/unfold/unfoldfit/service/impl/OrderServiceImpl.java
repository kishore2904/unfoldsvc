package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.OrderMapper;
import com.unfold.unfoldfit.model.dto.OrderDto;
import com.unfold.unfoldfit.model.entity.Category;
import com.unfold.unfoldfit.model.entity.Order;
import com.unfold.unfoldfit.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public void create(OrderDto orderDto){
        Order order = orderMapper.convertToOrder(orderDto);
        orderRepository.save(order);
    }

    public List<OrderDto> findAll(){
        List<Order> orders = orderRepository.findAll();
        return orderMapper.convertToOrderDto(orders);
    }

    public OrderDto findById(Integer orderId){
        Order order = orderRepository.findById(orderId).get();
        return orderMapper.convertToOrderDto(order);
    }

    public List<OrderDto> findByUserId(Integer userId){
        List<Order> orders = orderRepository.getOrdersByUserId(userId);
        return orderMapper.convertToOrderDto(orders);
    }

    public List<OrderDto> findByStatus(String status){
        List<Order> orders = orderRepository.getOrdersByStatus(status);
        return orderMapper.convertToOrderDto(orders);
    }

    public List<OrderDto> findByPaymentStatus(String paymentStatus){
        List<Order> orders = orderRepository.getOrdersByPaymentStatus(paymentStatus);
        return orderMapper.convertToOrderDto(orders);
    }

    public void update(Integer orderId,OrderDto orderDto) {

        Order order = orderRepository.findById(orderId).get();

        if(order!= null){

            Order updatedOrder = orderMapper.convertToOrder(orderDto);
            orderRepository.save(updatedOrder);

        }
    }

    public void delete(Integer orderId){

        orderRepository.deleteById(orderId);
    }
}
