package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDatabase {
    private List<Flight> flights;

    public FlightDatabase() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> findFlightsFrom(String city) {
        return flights.stream()
                .filter(f -> f.getDepartureCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(String city) {
        return flights.stream()
                .filter(f -> f.getArrivalCity().equals(city))
                .collect(Collectors.toList());
    }
}