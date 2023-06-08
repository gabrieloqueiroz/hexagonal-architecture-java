package com.queiroz.hexagonal.adapters.out;

import com.queiroz.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.queiroz.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.queiroz.hexagonal.application.core.domain.Address;
import com.queiroz.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {


    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    private AddressResponseMapper addressResponseMapper;

    @Autowired
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var address = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(address);
    }
}
