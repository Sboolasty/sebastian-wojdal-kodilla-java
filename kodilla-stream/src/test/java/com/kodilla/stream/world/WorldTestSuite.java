package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void worldPopulationTest() {
        //Given
        Continent africa = new Continent();
        africa.addCountry(new Country("Egypt", new BigDecimal("89125000")));
        africa.addCountry(new Country("Ethiopia", new BigDecimal("103764000")));
        africa.addCountry(new Country("Nigeria", new BigDecimal("181563000")));

        Continent europe = new Continent();
        europe.addCountry(new Country("Germany", new BigDecimal("82293457")));
        europe.addCountry(new Country("France", new BigDecimal("65233271")));
        europe.addCountry(new Country("United Kingdom", new BigDecimal("65110276")));

        World world = new World();
        world.addContinent(africa);
        world.addContinent(europe);

        //When
        BigDecimal population = world.getPopulation();

        //Then
        BigDecimal expected = new BigDecimal("587089004");
        Assert.assertEquals(expected, population);

    }
}