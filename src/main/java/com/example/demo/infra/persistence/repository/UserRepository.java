package com.example.demo.infra.persistence.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.infra.persistence.model.UserEntity;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    private final DynamoDBMapper mapper;

    public UserRepository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public void addUser(UserEntity user) {
        mapper.save(user);

    }

}
