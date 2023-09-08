package com.example.demo.infra.controller.UserController;

import java.util.List;

public class AddressesDto {
    List<AddressDto> addresses;

    public AddressesDto(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
