package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightSearchService db = new FlightSearchService();
        db.addFlight(new Flight("Gdańsk", "Kraków"));
        db.addFlight(new Flight("Warszawa", "Kraków"));
        db.addFlight(new Flight("Gdańsk", "Warszawa"));
        db.addFlight(new Flight("Kraków", "Poznań"));

        List<Flight> flightsFromGdansk = db.findFlightsFrom("Gdańsk");
        List<Flight> flightsToWroclaw = db.findFlightsTo("Wrocław");

        System.out.println("Loty z Gdańska: " + flightsFromGdansk);
        System.out.println("Loty do Krakowa: " + flightsToWroclaw);

    }
}