package com.iccteams.iccteams.service;

import com.iccteams.iccteams.model.Country;

import java.util.List;

public interface CountryService {
    public List<Country> findAll();

    public Country findById(int id);

    public void save(Country country);

    public void deleteById(int id);
}
