package com.example.demo.application.interactor;

import com.example.demo.application.gateways.OrderRepositoryGateway;
import com.example.demo.application.usecases.GetOrdersByUserUseCase;
import com.example.demo.infra.controller.OrderController.UserOrderOutput;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class GetOrdersByUserInteractor extends GetOrdersByUserUseCase {
    private final OrderRepositoryGateway orderRepositoryGateway;

    public GetOrdersByUserInteractor(OrderRepositoryGateway orderRepositoryGateway) {
        this.orderRepositoryGateway = orderRepositoryGateway;
    }

    @Override
    public List<UserOrderOutput> execute(String anInput) throws JsonProcessingException {
        return orderRepositoryGateway.getUserOrders(anInput);
    }
}
