package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightSearchService searchService = new FlightSearchService();

        // Dodanie przykładowych lotów
       searchService.addFlight(new Flight("Gdańsk", "Wrocław", 15151));
       searchService.addFlight(new Flight("Warszawa", "Kraków", 51515));
       searchService.addFlight(new Flight("Kraków", "Gdańsk", 12514));
       searchService.addFlight(new Flight("Poznań", "Wrocław", 44444));

        // Wyszukanie lotów
        List<Flight> flightsFromGdansk = searchService.getAllFlightsFromCity("Gdańsk");
        List<Flight> flightsToKrakow = searchService.getAllFlightsToCity("Kraków");
        List<Flight> flightsThroughKrakow = searchService.getAllFlightsThroughCity("Gdańsk", "Kraków");

        // Wyświetlenie wyników
        System.out.println("Loty z Gdańska: " + flightsFromGdansk);
        System.out.println("Loty do Krakowa: " + flightsToKrakow);
        System.out.println("Loty przez Kraków z Gdańska do Wrocławia: " + flightsThroughKrakow);
    }
}