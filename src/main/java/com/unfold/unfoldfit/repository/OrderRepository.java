package com.unfold.unfoldfit.repository;

import com.unfold.unfoldfit.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    String FIND_ORDERS_BY_USERID = """
            SELECT ORDERS FROM Order ORDERS WHERE ORDERS.userId = :userId 
            """;

    String FIND_ORDERS_BY_STATUS = """
            SELECT ORDERS FROM Order ORDERS WHERE ORDERS.status = :status 
            """;

    String FIND_ORDERS_BY_PAYMENT_STATUS = """
            SELECT ORDERS FROM Order ORDERS WHERE ORDERS.paymentStatus = :paymentStatus 
            """;

    @Query(value = FIND_ORDERS_BY_USERID)
    List<Order> getOrdersByUserId(Integer userId);

    @Query(value = FIND_ORDERS_BY_STATUS)
    List<Order> getOrdersByStatus(String status);

    @Query(value = FIND_ORDERS_BY_PAYMENT_STATUS)
    List<Order> getOrdersByPaymentStatus(String paymentStatus);





}
