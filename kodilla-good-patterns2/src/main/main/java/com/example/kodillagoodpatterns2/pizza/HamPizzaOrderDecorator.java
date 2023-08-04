package com.example.kodillagoodpatterns2.pizza;


import java.math.BigDecimal;

public class HamPizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public HamPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}