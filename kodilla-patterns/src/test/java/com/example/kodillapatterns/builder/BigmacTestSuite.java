package com.example.kodillapatterns.builder;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("onion")
                .ingredient("bacon")
                .build();

        System.out.println(bigmac);

        //when
        int numberOfIngredients = bigmac.getIngredients().size();

        //then
        assertEquals("with sesame", bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("barbecue", bigmac.getSauce());
        assertTrue(bigmac.getIngredients().contains("lettuce"));
        assertTrue(bigmac.getIngredients().contains("onion"));
        assertTrue(bigmac.getIngredients().contains("bacon"));
        assertEquals(3, numberOfIngredients);
    }
}