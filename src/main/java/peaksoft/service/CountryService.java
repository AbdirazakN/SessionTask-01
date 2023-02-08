package peaksoft.service;

import peaksoft.models.Country;

import java.util.List;

public interface CountryService {
    String saveCountry(Country country);

    String saveMoreCountries(List<Country> countries);

    List<Country> getAllCountries();

    Country findById(Long id);

    Country removeById(Long id);

    String removeAllCountries();

    Country update(Long id, Country country);

    Country findLongDescription();

    int findQuantityCountry(String country);

}
