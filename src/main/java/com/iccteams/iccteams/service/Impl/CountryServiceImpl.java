package com.iccteams.iccteams.service.Impl;

import com.iccteams.iccteams.model.Country;
import com.iccteams.iccteams.repository.CountryRepository;
import com.iccteams.iccteams.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Country findById(int id) {
        Optional<Country> result = countryRepository.findById(id);
        Country country=null;
        if(result.isPresent()){
            country=result.get();
        }
        else{
            throw new RuntimeException("Did not find employee product");
        }

        return country;
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);

    }

    @Override
    public void deleteById(int id) {
            countryRepository.deleteById(id);
    }
}
