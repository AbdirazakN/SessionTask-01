package peaksoft.service;

import peaksoft.models.Address;

import java.util.List;

public interface AddressService {
    String saveAddress(Address address);

    String saveMoreAddresses(List<Address> addresses);

    List<Address> getAllAddresses();

    Address findById(Long id);

    Address removeById(Long id);

    String removeAllAddresses();

    Address update(Long id, Address address);
}
