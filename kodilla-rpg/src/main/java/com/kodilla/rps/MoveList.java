package com.kodilla.rps;

public enum MoveList {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors"),
    LIZARD("lizard"),
    SPOCK("spock");

    private final String value;
    MoveList(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}