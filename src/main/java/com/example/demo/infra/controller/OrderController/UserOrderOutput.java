package com.example.demo.infra.controller.OrderController;

import com.example.demo.domain.entity.Status;
import com.example.demo.infra.controller.UserController.AddressDto;

public record UserOrderOutput(String customerId, Double total, String orderId, AddressDto address, Status Status) {
}
