package com.example.demo.infra.adapter;

import com.example.demo.application.gateways.UserRepositoryGateway;
import com.example.demo.domain.entity.User;
import com.example.demo.infra.controller.Mapper;
import com.example.demo.infra.persistence.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UserRepositoryGatewayImpl implements UserRepositoryGateway {

    private final UserRepository userRepository;

    public UserRepositoryGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) throws JsonProcessingException {
        var mapper = Mapper.UserDomainToEntity(user);
        userRepository.addUser(mapper);

    }
}
