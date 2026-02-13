/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* NOTE: For API specifications, see:
 * https://open-meteo.com/en/docs#hourly_parameter_definition
 */

public class WeatherAPI extends WebAPI {
    public static WeatherData getWeather(double longitude, double latitude) {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude +
                    "&longitude=" + longitude + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m";
            HttpURLConnection apiConnection = fetchApiResponse(url);

            if (apiConnection.getResponseCode() != 200) {
                System.err.println("Error: Could not connect to API.");
                return null;
            }

            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");

            double temperature = (double) currentWeatherJson.get("temperature_2m");

            long relativeHumidity = (long) currentWeatherJson.get("relative_humidity_2m");

            double pressure = (double) currentWeatherJson.get("pressure_msl_surface_pressure");

            double windSpeed = (double) currentWeatherJson.get("wind_speed_10m");

            double windDirection = (double) currentWeatherJson.get("wind_direction_10m");

            return new WeatherData(
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