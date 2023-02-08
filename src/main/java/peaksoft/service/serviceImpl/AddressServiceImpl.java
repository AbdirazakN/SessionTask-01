package peaksoft.service.serviceImpl;

import peaksoft.models.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.repositoryImpl.AddressRepositoryImpl;
import peaksoft.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository = new AddressRepositoryImpl();
    @Override
    public String saveAddress(Address address) {
        return addressRepository.saveAddress(address);
    }

    @Override
    public String saveMoreAddresses(List<Address> addresses) {
        return addressRepository.saveMoreAddresses(addresses);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address removeById(Long id) {
        return addressRepository.removeById(id);
    }

    @Override
    public String removeAllAddresses() {
        return addressRepository.removeAllAddresses();
    }

    @Override
    public Address update(Long id, Address address) {
        return addressRepository.update(id,address);
    }
}
