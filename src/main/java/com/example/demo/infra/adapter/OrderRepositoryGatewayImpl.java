package com.example.demo.infra.adapter;

import com.example.demo.application.gateways.OrderRepositoryGateway;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Status;
import com.example.demo.infra.controller.Mapper;
import com.example.demo.infra.controller.OrderController.UserOrderOutput;
import com.example.demo.infra.controller.UserController.AddressDto;
import com.example.demo.infra.persistence.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRepositoryGatewayImpl implements OrderRepositoryGateway {

    private final OrderRepository orderRepository;

    public OrderRepositoryGatewayImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) throws JsonProcessingException {
        var entity = Mapper.orderDomainToEntity(order);
        orderRepository.createOrder(entity);
    }

    @Override
    public List<UserOrderOutput> getUserOrders(String username) {
        return orderRepository.getOrders(username)
                .stream()
                .map(orderEntity -> {
                    try {
                        var address = new ObjectMapper().readValue(orderEntity.getAddress(), AddressDto.class);
                        return  new UserOrderOutput(orderEntity.getCustomerId(), orderEntity.getTotal(), orderEntity.getOrderId(), address, Status.valueOf(orderEntity.getStatus()));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}
