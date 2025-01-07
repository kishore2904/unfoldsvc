package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.dto.OrderDto;
import com.unfold.unfoldfit.service.impl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/unfold")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

     @GetMapping(value="/allOrders")
    public ResponseEntity<List<OrderDto>> findAllOrder(){
        return ResponseEntity.ok(orderServiceImpl.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findOrderByOrderId(@PathVariable Integer orderId){
        return ResponseEntity.ok(orderServiceImpl.findById(orderId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> findOrderByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(orderServiceImpl.findByUserId(userId));
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<OrderDto>> findOrderByStatus(@PathVariable String status){
        return ResponseEntity.ok(orderServiceImpl.findByStatus(status));
    }

    @GetMapping("/{paymentStatus}")
    public ResponseEntity<List<OrderDto>> findOrderByPaymentStatus(@PathVariable String paymentStatus){
        return ResponseEntity.ok(orderServiceImpl.findByPaymentStatus(paymentStatus));
    }

    @PostMapping("/orders")
    ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto){
        orderServiceImpl.create(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/orders/{orderId}")
    ResponseEntity<Void> updateCategory(@PathVariable Integer orderId, @RequestBody OrderDto orderDto){

        orderServiceImpl.update(orderId,orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/orders/{deleteId}")
    ResponseEntity<Void> deleteCategoryWithProduct(@PathVariable Integer orderId){

        orderServiceImpl.delete(orderId);
        return ResponseEntity.noContent().build();

    }
}
