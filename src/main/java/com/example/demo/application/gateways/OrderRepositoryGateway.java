package com.example.demo.application.gateways;

import com.example.demo.domain.entity.Order;
import com.example.demo.infra.controller.OrderController.UserOrderOutput;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OrderRepositoryGateway {
    void createOrder(Order order) throws JsonProcessingException;
    List<UserOrderOutput> getUserOrders(String username);
}
