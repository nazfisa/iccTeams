package com.iccteams.iccteams.repository;

import com.iccteams.iccteams.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findAllByOrderByNameAsc();
}
