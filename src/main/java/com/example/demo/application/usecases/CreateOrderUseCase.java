package com.example.demo.application.usecases;

import com.example.demo.infra.controller.OrderController.OrderCreateInputRequest;
import com.example.demo.infra.controller.OrderController.OrderCreateOutput;

public abstract class CreateOrderUseCase
        extends UseCase<OrderCreateInputRequest, OrderCreateOutput> {
}
