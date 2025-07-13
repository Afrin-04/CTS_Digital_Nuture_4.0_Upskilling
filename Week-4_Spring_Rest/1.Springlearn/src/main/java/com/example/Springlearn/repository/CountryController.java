package com.example.Springlearn.repository;

import com.example.Springlearn.model.Country;
import com.example.Springlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryRepository.findById(code).orElse(null);
    }
}

