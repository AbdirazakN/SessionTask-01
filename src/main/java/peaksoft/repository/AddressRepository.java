package peaksoft.repository;

import peaksoft.models.Address;
import peaksoft.models.Country;

import java.util.List;

public interface AddressRepository {
    // SAVE ONE ADDRESS
    String saveAddress(Address address);

    // SAVE MORE ADDRESSES
    String saveMoreAddresses(List<Address> addresses);

    // GET ALL ADDRESSES

    List<Address> getAllAddresses();

    // FIND ADDRESS BY ID

    Address findById(Long id);

    // REMOVE COUNTRY BY ID

    Address removeById(Long id);

    // REMOVE ALL ADDRESSES

    String removeAllAddresses();

    // UPDATE

    Address update(Long id, Address address);

}
