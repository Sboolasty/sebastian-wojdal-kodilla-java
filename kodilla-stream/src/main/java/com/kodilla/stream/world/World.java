package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Continent> continents = new ArrayList<>();

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPopulation() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPopulation)
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));
    }
}