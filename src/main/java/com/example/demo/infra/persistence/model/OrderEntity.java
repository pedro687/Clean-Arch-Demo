package com.example.demo.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName = "cleanArchTable")
public class OrderEntity {

    private static final String SK_PREFIX = "ORDER";
    private String pk;


    private CompositeKey sk;

    private String orderId;

    private String customerId;

    private String address;

    private String status;

    private Double total;


    @DynamoDBHashKey(attributeName = "pk")
    public String getPk() {
        return pk;
    }

    @DynamoDBHashKey(attributeName = "sk")
    @DynamoDBTypeConverted(converter = CompositeKeyConverter.class)
    public CompositeKey getSk() {
        return sk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }


    public void setSk(CompositeKey sk) {
        this.sk = sk;
    }


    @DynamoDBAttribute(attributeName = "orderId")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    @DynamoDBAttribute(attributeName = "customerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    @DynamoDBAttribute(attributeName = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @DynamoDBAttribute(attributeName = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderEntity(String orderId, String customerId, String address, String status, Double total) {
        this.pk = customerId;
        this.sk = new CompositeKey(SK_PREFIX, orderId);
        this.orderId = orderId;
        this.customerId = customerId;
        this.address = address;
        this.status = status;
        this.total = total;
    }


    @DynamoDBAttribute(attributeName = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderEntity() {
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "pk='" + pk + '\'' +
                ", sk=" + sk +
                ", orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
