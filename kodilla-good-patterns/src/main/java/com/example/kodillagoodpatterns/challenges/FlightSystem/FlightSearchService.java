package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService {
    private List<Flight> flights;

    public FlightSearchService() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getAllFlightsFromCity(String city) {
        return flights.stream()
                .filter(f -> f.getDepartureCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> getAllFlightsToCity(String city) {
        return flights.stream()
                .filter(f -> f.getArrivalCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> getAllFlightsThroughCity(String startCity, String stopCity) {
        return flights.stream()
                .filter(f -> f.getDepartureCity().equals(startCity))
                .filter(f -> f.getStopoverCity() != null && f.getStopoverCity().equals(stopCity))
                .collect(Collectors.toList());
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public void clearAllFlights() {
        flights.clear();
    }
}