package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.Objects;

public class Flight {
    private String departureCity;
    private String transferCity;
    private String arrivalCity;

    public Flight(String departureCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }
    public String getTransferCity() {
        return transferCity;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Flight)) return false;
        Flight f = (Flight) obj;
        return Objects.equals(departureCity, f.departureCity)
                && Objects.equals(transferCity, f.transferCity)
                && Objects.equals(arrivalCity, f.arrivalCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity);
    }
}