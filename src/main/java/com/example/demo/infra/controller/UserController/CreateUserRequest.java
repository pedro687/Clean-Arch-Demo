package com.example.demo.infra.controller.UserController;

public record CreateUserRequest(String username,  String fullName, String email, AddressesDto addressesDto) {
}
