package com.example.demo.application.interactor;

import com.example.demo.application.gateways.UserRepositoryGateway;
import com.example.demo.application.usecases.CreateUserUseCase;
import com.example.demo.infra.controller.UserController.CreateUserRequest;
import com.example.demo.infra.controller.Mapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CreateUserInteractor extends CreateUserUseCase {

    private final UserRepositoryGateway userRepositoryGateway;

    public CreateUserInteractor(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public Void execute(CreateUserRequest anInput) throws JsonProcessingException {
        var userDomain = Mapper.requestToUser(anInput);
        userRepositoryGateway.createUser(userDomain);
        Void Void = null;
        return Void;
    }
}
