package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 Celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemperature() {
        double average = 0;
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            average += entry.getValue();
        }
        return average/temperatures.getTemperatures().size();
    }
    public double medianTemperature(){
        ArrayList<Double> values = new ArrayList<>();
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            values.add(entry.getValue());
        }
        values.sort(Comparator.naturalOrder());
        return ((values.size() % 2) == 0) ? values.get(values.size() / 2) / 2 + values.get(values.size() / 2 - 1) / 2 : values.get(values.size() / 2);
    }
}