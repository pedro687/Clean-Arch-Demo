package com.example.demo.domain.entity;

import com.example.demo.infra.controller.UserController.AddressesDto;

public record  User(String username, String emaild, String fullName, AddressesDto addresses) {
}
