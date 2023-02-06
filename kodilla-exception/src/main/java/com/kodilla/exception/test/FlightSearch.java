package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();

        if (!airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException();
        }

        return airports.get(flight.getArrivalAirport());
    }
}