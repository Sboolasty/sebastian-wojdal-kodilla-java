package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private String name;
    private BigDecimal countryPopulation;

    public Country(String name, BigDecimal countryPopulation) {
        this.name = name;
        this.countryPopulation = countryPopulation;
    }

    public BigDecimal getPopulation() {
        return countryPopulation;
    }
}