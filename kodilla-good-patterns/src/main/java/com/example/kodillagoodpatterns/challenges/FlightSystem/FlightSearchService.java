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
        List<Flight> departureFlights = findFlightsFrom(departureCity);
        List<Flight> arrivalFlights = findFlightsTo(arrivalCity);

        List<Flight> connectingFlights = departureFlights.stream()
                .filter(flight -> flight.getArrivalCity().equals(connectingCity))
                .flatMap(flight -> arrivalFlights.stream()
                        .filter(arrivalFlight -> arrivalFlight.getDepartureCity().equals(connectingCity))
                        .filter(arrivalFlight -> arrivalFlight.getArrivalCity().equals(arrivalCity))
                        .map(arrivalFlight -> new Flight(flight.getDepartureCity(), arrivalFlight.getArrivalCity())))
                .collect(Collectors.toList());

        return connectingFlights;
    }
}