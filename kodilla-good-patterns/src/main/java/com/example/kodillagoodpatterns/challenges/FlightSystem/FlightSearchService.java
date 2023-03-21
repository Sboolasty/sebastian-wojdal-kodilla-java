package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {
    private List<Flight> flights;

    public FlightSearchService() {
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
    public List<Flight> getAllFlightsThroughCity(String fromCity, String throughCity, String toCity) {
        return flights.stream()
                .filter(f -> f.getDepartureCity().equals(fromCity))
                .filter(f -> f.getArrivalCity().equals(toCity))
                .filter(f -> f.getTransferCity().equals(throughCity))
                .collect(Collectors.toList());
    }
}