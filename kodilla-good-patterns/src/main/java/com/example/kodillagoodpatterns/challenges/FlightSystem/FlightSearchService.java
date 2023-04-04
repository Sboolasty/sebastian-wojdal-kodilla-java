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
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
    }

    public List<Flight> getFlights() {
        return this.flights;
    }

    public List<Flight> findFlightsFrom(String departureCity) {
        return this.flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(String arrivalCity) {
        return this.flights.stream()
                .filter(flight -> flight.getArrivalCity().equals(arrivalCity))
                .collect(Collectors.toList());
    }

    public List<Flight> findConnectingFlights(String departureCity, String arrivalCity, String connectingCity) {
        List<Flight> departureToConnectingFlights = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity) && flight.getArrivalCity().equals(connectingCity))
                .collect(Collectors.toList());
        List<Flight> connectingToArrivalFlights = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(connectingCity) && flight.getArrivalCity().equals(arrivalCity))
                .collect(Collectors.toList());
        List<Flight> connectingFlights = new ArrayList<>();
        connectingFlights.addAll(departureToConnectingFlights);
        connectingFlights.addAll(connectingToArrivalFlights);
        return connectingFlights;
    }
}