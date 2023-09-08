package com.example.demo.infra.controller.OrderController;

import com.example.demo.infra.controller.UserController.AddressDto;

public record OrderCreateInputRequest(String customerId, Double total,  AddressDto address) {
}
