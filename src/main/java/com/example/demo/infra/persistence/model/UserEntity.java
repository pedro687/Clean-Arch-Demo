package com.example.demo.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "cleanArchTable")
public class UserEntity {

    private CompositeKey pk;

    private CompositeKey sk;


    public UserEntity() {
    }


    @DynamoDBHashKey(attributeName = "pk")
    @DynamoDBTypeConverted(converter = CompositeKeyConverter.class)
    public CompositeKey getPk() {
        return pk;
    }

    public void setPk(CompositeKey pk) {
        this.pk = pk;
    }

    public void setSk(CompositeKey sk) {
        this.sk = sk;
    }

    @DynamoDBRangeKey(attributeName = "sk")
    @DynamoDBTypeConverted(converter = CompositeKeyConverter.class)
    public CompositeKey getSk() {
        return sk;
    }

    private static final String PK_PREFIX = "USER";
    private static final String SK_PREFIX = "EMAIL";

    private String username;

    private String email;

    private String fullName;

    private String addresses;

    public UserEntity(String username, String email, String fullName, String addresses) {
        this.pk = new CompositeKey(PK_PREFIX, username);
        this.sk = new CompositeKey(SK_PREFIX, email);
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.addresses = addresses;
    }

    @DynamoDBAttribute(attributeName = "username")
    public String getUsername() {
        return username;
    }


    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }


    @DynamoDBAttribute(attributeName = "fullName")
    public String getFullName() {
        return fullName;
    }


    @DynamoDBAttribute(attributeName = "addresses")
    public String getAddresses() {
        return addresses;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", addresses='" + addresses + '\'' +
                ", pk=" + pk +
                ", sk=" + sk +
                '}';
    }
}
