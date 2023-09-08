package com.example.demo.infra.persistence.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.infra.persistence.model.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public OrderRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void createOrder(OrderEntity order)  {
        dynamoDBMapper.save(order);
    }

    public List<OrderEntity> getOrders(String username) {
        Map<String, AttributeValue> attributeValue = new HashMap<>();
        System.out.println(username);
        attributeValue.put(":val1", new AttributeValue().withS(username));

        DynamoDBQueryExpression<OrderEntity> queryExpression = new DynamoDBQueryExpression<OrderEntity>()
                .withKeyConditionExpression("pk = :val1")
                .withExpressionAttributeValues(attributeValue);

        return dynamoDBMapper.query(OrderEntity.class, queryExpression);
    }

}
