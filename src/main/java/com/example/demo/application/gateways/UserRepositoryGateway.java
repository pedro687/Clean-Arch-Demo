package com.example.demo.application.gateways;

import com.example.demo.domain.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserRepositoryGateway {
    void createUser(User user) throws JsonProcessingException;
}
