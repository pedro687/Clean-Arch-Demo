package com.example.demo.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import static com.example.demo.infra.persistence.model.CompositeKey.DELIMITER;

public class CompositeKeyConverter implements DynamoDBTypeConverter<String, CompositeKey> {

    @Override
    public String convert(CompositeKey compositeKey) {
        return compositeKey.getPrefix() + DELIMITER + compositeKey.getPostfix();
    }

    @Override
    public CompositeKey unconvert(String s) {
        String[] parts = s.split(DELIMITER);
        return new CompositeKey(parts[0], parts[1]);
    }
}
