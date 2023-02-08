package peaksoft.repository;

import peaksoft.config.HiberConfig;
import peaksoft.models.Country;

import java.util.List;

public interface CountryRepository {
    // SAVE ONE COUNTRY
    String saveCountry(Country country);

    // SAVE MORE COUNTRY
    String saveMoreCountries(List<Country> countries);

    // GET ALL COUNTRIES

    List<Country> getAllCountries();

    // FIND COUNTRY BY ID

    Country findById(Long id);

    // REMOVE COUNTRY BY ID

    Country removeById(Long id);

    // REMOVE ALL COUNTRIES

    String removeAllCountries();

    // UPDATE

    Country update(Long id, Country country);

    // FIND LONG LENGTH DESC COUNTRY

    Country findLongDescription();

    // FIND HOW MANY COUNTRIES

    int findQuantityCountry(String country);

}
