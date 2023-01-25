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
        double median;
        List<Double> medianList = new ArrayList<>(temperatures.getTemperatures().values());
        medianList.sort(Comparator.naturalOrder());

        if (medianList.size() % 2 == 0) {
            return medianList.get(medianList.size()/2) + medianList.get((medianList.size() / 2) - 1);
        } else {
            return medianList.get(medianList.size() / 2);
        }
    }
}