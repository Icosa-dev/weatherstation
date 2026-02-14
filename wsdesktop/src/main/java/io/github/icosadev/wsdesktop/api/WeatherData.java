/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

/* NOTE: For API specifications, see:
 * https://open-meteo.com/en/docs#hourly_parameter_definition
 */
public class WeatherData {
    private String time;
    private double temperature; // temperature_2m (C)
    private long   relativeHumidity; // relative_humidity_2m (%)
    private double pressure; // pressure_msl_surface_pressure (hPa)
    private double windSpeed; // wind_speed_10m (km/h)
    private long windDirection; // wind_direction_10m (deg.)

    WeatherData(
            String time,
            double temperature,
            long   relativeHumidity,
            double pressure,
            double windSpeed,
            long windDirection) {
        
        this.time = time;
        this.temperature = temperature;
        this.relativeHumidity = relativeHumidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getTemperatureF() {
        return (temperature * 1.8) + 32; // C to F conversion
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public long getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(long relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindSpeedMph() {
        return windSpeed * 0.621371;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(long windDirection) {
        this.windDirection = windDirection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherData [time=" + time + ", temperature=" + temperature + ", relativeHumidity=" + relativeHumidity
                + ", pressure=" + pressure + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + "]";
    }
}