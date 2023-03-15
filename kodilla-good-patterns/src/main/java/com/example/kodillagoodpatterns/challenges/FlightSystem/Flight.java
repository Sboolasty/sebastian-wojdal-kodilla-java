package com.example.kodillagoodpatterns.challenges.FlightSystem;

import java.util.Objects;

public class Flight {
    private String departureCity;
    private String arrivalCity;
    private String stopoverCity;
    private int flightNumber;

    public Flight(String departureCity, String arrivalCity, int flightNumber) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.flightNumber = flightNumber;
    }

    public Flight(String departureCity, String stopoverCity, String arrivalCity, int flightNumber) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.stopoverCity = stopoverCity;
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getStopoverCity() {
        return stopoverCity;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setStopoverCity(String stopoverCity) {
        this.stopoverCity = stopoverCity;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightNumber != flight.flightNumber) return false;
        if (!departureCity.equals(flight.departureCity)) return false;
        if (!arrivalCity.equals(flight.arrivalCity)) return false;
        return stopoverCity != null ? stopoverCity.equals(flight.stopoverCity) : flight.stopoverCity == null;
    }
    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity, stopoverCity);
    }
}