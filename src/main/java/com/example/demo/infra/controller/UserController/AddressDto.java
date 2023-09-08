package com.example.demo.infra.controller.UserController;

public class AddressDto {

    private String cep;

    private String country;

    private String city;

    private String state;


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AddressDto(String cep, String country, String city, String state) {
        this.cep = cep;
        this.country = country;
        this.city = city;
        this.state = state;
    }

    public AddressDto() {
    }
}
