package peaksoft.service.serviceImpl;

import peaksoft.models.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.repositoryImpl.CountryRepositoryImpl;
import peaksoft.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository = new CountryRepositoryImpl();
    @Override
    public String saveCountry(Country country) {
        return countryRepository.saveCountry(country);
    }

    @Override
    public String saveMoreCountries(List<Country> countries) {
        return countryRepository.saveMoreCountries(countries);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country removeById(Long id) {
        return countryRepository.removeById(id);
    }

    @Override
    public String removeAllCountries() {
        return countryRepository.removeAllCountries();
    }

    @Override
    public Country update(Long id, Country country) {
        return countryRepository.update(id,country);
    }

    @Override
    public Country findLongDescription() {
        return countryRepository.findLongDescription();
    }

    @Override
    public int findQuantityCountry(String country) {
        return countryRepository.findQuantityCountry(country);
    }
}
