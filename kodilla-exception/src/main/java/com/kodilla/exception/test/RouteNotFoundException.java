
package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException() {}
    public RouteNotFoundException(String message) {
        super(message);
    }
}