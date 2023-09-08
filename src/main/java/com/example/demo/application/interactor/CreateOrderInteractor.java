package com.example.demo.application.interactor;

import com.example.demo.application.gateways.OrderRepositoryGateway;
import com.example.demo.application.usecases.CreateOrderUseCase;
import com.example.demo.domain.entity.Order;
import com.example.demo.infra.controller.Mapper;
import com.example.demo.infra.controller.OrderController.OrderCreateInputRequest;
import com.example.demo.infra.controller.OrderController.OrderCreateOutput;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CreateOrderInteractor extends CreateOrderUseCase {
    private final OrderRepositoryGateway orderRepositoryGateway;

    public CreateOrderInteractor(OrderRepositoryGateway orderRepositoryGateway) {
        this.orderRepositoryGateway = orderRepositoryGateway;
    }

    @Override
    public OrderCreateOutput execute(OrderCreateInputRequest anInput) throws JsonProcessingException {
        Order order = Mapper.orderCreateRequestToDomain(anInput);
        orderRepositoryGateway.createOrder(order);
        return new OrderCreateOutput("Pedido criado com sucesso!");
    }
}
