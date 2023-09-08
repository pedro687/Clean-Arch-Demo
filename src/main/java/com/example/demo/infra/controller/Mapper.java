package com.example.demo.infra.controller;

import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Status;
import com.example.demo.domain.entity.User;
import com.example.demo.infra.controller.OrderController.OrderCreateInputRequest;
import com.example.demo.infra.controller.UserController.CreateUserRequest;
import com.example.demo.infra.persistence.model.OrderEntity;
import com.example.demo.infra.persistence.model.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class Mapper {
    public static User requestToUser(CreateUserRequest userRequest) {
        return new User(userRequest.username(), userRequest.email(), userRequest.fullName(), userRequest.addressesDto());
    }

    public static UserEntity UserDomainToEntity(User user) throws JsonProcessingException {
        var json = new ObjectMapper().writeValueAsString(user.addresses());
        return new UserEntity(user.username(), user.emaild(), user.fullName(), json);
    }

    public static Order orderCreateRequestToDomain(OrderCreateInputRequest orderCreateInputRequest) {
        return new Order(orderCreateInputRequest.customerId(), orderCreateInputRequest.total(), UUID.randomUUID().toString(),  orderCreateInputRequest.address(), Status.CREATED);
    }

    public static OrderEntity orderDomainToEntity(Order order) throws JsonProcessingException {
        var json = new ObjectMapper().writeValueAsString(order.address());
        return new OrderEntity(order.orderId(), order.customerId(), json, order.Status().toString(), order.total());
    }
}
