package com.example.Springlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @Id
    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        LOGGER.debug("Getting code: {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Setting code: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Getting name: {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Setting name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country {code='" + code + "', name='" + name + "'}";
    }
}
