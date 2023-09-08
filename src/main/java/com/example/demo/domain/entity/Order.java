package com.example.demo.domain.entity;

import com.example.demo.infra.controller.UserController.AddressDto;

public record Order(String customerId, Double total, String orderId, AddressDto address, Status Status) {
}
