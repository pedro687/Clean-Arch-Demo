package com.example.demo.infra.config;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.application.gateways.OrderRepositoryGateway;
import com.example.demo.application.gateways.UserRepositoryGateway;
import com.example.demo.application.interactor.CreateOrderInteractor;
import com.example.demo.application.interactor.CreateUserInteractor;
import com.example.demo.application.interactor.GetOrdersByUserInteractor;
import com.example.demo.application.usecases.CreateOrderUseCase;
import com.example.demo.application.usecases.CreateUserUseCase;
import com.example.demo.application.usecases.GetOrdersByUserUseCase;
import com.example.demo.infra.adapter.OrderRepositoryGatewayImpl;
import com.example.demo.infra.adapter.UserRepositoryGatewayImpl;
import com.example.demo.infra.persistence.repository.OrderRepository;
import com.example.demo.infra.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    UserRepository userRepository(DynamoDBMapper dynamoDBMapper) {
        return new UserRepository(dynamoDBMapper);
    }


    @Bean
    OrderRepositoryGateway orderRepositoryGateway(OrderRepository orderRepository) {
        return new OrderRepositoryGatewayImpl(orderRepository);
    }

    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository userRepository) {
        return new UserRepositoryGatewayImpl(userRepository);
    }


    @Bean
    CreateUserInteractor createUserInteractor(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserInteractor(userRepositoryGateway);
    }


    @Bean
    CreateUserUseCase createUserUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserInteractor(userRepositoryGateway);
    }

    @Bean
    CreateOrderUseCase createOrderInteractor(OrderRepositoryGateway orderRepositoryGateway) {
        return new CreateOrderInteractor(orderRepositoryGateway);
    }

    @Bean
    GetOrdersByUserUseCase getOrdersByUserUseCase(OrderRepositoryGateway orderRepositoryGateway) {
        return new GetOrdersByUserInteractor(orderRepositoryGateway);
    }
}
