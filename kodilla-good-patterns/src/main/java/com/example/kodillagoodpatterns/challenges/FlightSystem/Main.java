package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightSearchService flightSearchService = new FlightSearchService();

        Flight flight1 = new Flight("KTW", "WAW");
        Flight flight2 = new Flight("WAW", "KRK");
        Flight flight3 = new Flight("WAW", "LDZ");

        flightSearchService.addFlight(flight1);
        flightSearchService.addFlight(flight2);
        flightSearchService.addFlight(flight3);

        List<Flight> connectingFlights = flightSearchService.findConnectingFlights("KTW", "KRK", "WAW");

        System.out.println("Connecting flights:");
        for (Flight flight : connectingFlights) {
            System.out.println(flight.getDepartureCity() + " - " + flight.getArrivalCity());
        }
  }
}