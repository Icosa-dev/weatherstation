/**
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

/**
 * Represents a single weather observation retrieved from the Open-Meteo API.
 * 
 * <p>
 * This class stores meteorological data including temperature, humidity,
 * atmospheric pressure, wind speed, wind direction, and timestamp information.
 * All base values are stored in metric units as returned by the API.
 * </p>
 * 
 * <p>
 * <b>Units:</b>
 * <ul>
 * <li>Temperature: degrees Celsius (°C)</li>
 * <li>Relative Humidity: percent (%)</li>
 * <li>Pressure: hectopascals (hPa)</li>
 * <li>Wind Speed: kilometers per hour (km/h)</li>
 * <li>Wind Direction: degrees (0–360°)</li>
 * <li>Time: ISO-8601 formatted string</li>
 * </ul>
 * </p>
 * 
 * @author LJC
 * @since 1.0
 */
public class WeatherData {
    private String time;
    private double temperature;
    private long relativeHumidity;
    private double pressure;
    private double windSpeed;
    private long windDirection;

    /**
     * Initializes a {@code WeatherData} object with initialized data.
     * 
     * @param time the time in which the rest of the data was collected
     * @param temperature the tempurature of the location in degrees Celcius (C)
     * @param relativeHumidity the relative humidity of the location in percent (%)
     * @param pressure the surface pressure of the location in hectopascals (hPa)
     * @param windSpeed the wind speed at 10 meters altitude in kilometers per hour (KpH)
     * @param windDirection the wind direction at 10 meters altitude in degrees 
     * 
     * @since 1.0
     */
    WeatherData(
            String time,
            double temperature,
            long relativeHumidity,
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

    /**
     * Returns {@link #temperature} as is in degrees Celcius.
     * 
     * @return tempurature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Returns {@link #temperature} after conversion to degrees Farenheit.
     * 
     * @return tempurature in Farenheit
     */
    public double getTemperatureF() {
        return (temperature * 1.8) + 32; // C to F conversion
    }

    /**
     * Sets the {@link #temperature} value.
     * 
     * @param temperature the new tempurature <b>in degrees Celcius</b>
     */
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

    /**
     * Returns {@link #windSpeed} as is in kilometers per hour (KpH).
     * 
     * @return speed of the wind in KpH
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Returns {@link #windSpeed} after conversion to miles per hour (MpH).
     * 
     * @return speed of the wind in MpH
     */
    public double getWindSpeedMph() {
        return windSpeed * 0.621371;
    }

    /**
     * Sets the {@link #windSpeed} value.
     * 
     * @param temperature the new speed of the wind <b>in KpH</b>
     */
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