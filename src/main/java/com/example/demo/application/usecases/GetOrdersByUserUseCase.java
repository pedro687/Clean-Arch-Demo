package com.example.demo.application.usecases;

import com.example.demo.infra.controller.OrderController.UserOrderOutput;

import java.util.List;

public abstract  class GetOrdersByUserUseCase
        extends UseCase<String, List<UserOrderOutput>>{
}
