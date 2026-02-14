/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherAPI extends WebAPI {
    // TODO: Make this take a Coordinate class input instead of seperate
    // doubles
    public static WeatherData getWeather(double longitude, double latitude) {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" 
                + latitude + "&longitude=" + longitude 
                + "&hourly=temperature_2m&current=temperature_2m,relative_humidity_2m,surface_pressure,wind_speed_10m,wind_direction_10m";
            HttpURLConnection apiConnection = fetchApiResponse(url);

            if (apiConnection.getResponseCode() != 200) {
                System.err.println("Error: Could not connect to API.");
                return null;
            }

            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");

            String time = (String) currentWeatherJson.get("time");

            double temperature = (double) currentWeatherJson.get("temperature_2m");

            long relativeHumidity = (long) currentWeatherJson.get("relative_humidity_2m");

            double pressure = (double) currentWeatherJson.get("surface_pressure");

            double windSpeed = (double) currentWeatherJson.get("wind_speed_10m");

            long windDirection = (long) currentWeatherJson.get("wind_direction_10m");

            return new WeatherData(
                    time, 
                    temperature,
                    relativeHumidity,
                    pressure,
                    windSpeed,
                    windDirection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}