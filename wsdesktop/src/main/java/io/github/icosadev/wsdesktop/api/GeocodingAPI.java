/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.api;

import java.net.HttpURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GeocodingAPI extends WebAPI {
    public static Coordinates getCoordinates(String city) {
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                city + "&count=1&language=en&format=json";
        
        try {
            // This is similar to another code block in
            // the WeatherAPI. Try to make it so this doesn't
            // need to be written twice.
            // DO NOT REPEAT YOURSELF
            HttpURLConnection apiConnection = fetchApiResponse(urlString);

            if (apiConnection.getResponseCode() != 200) {
                System.err.println("Error: Could not connect to API.");
                return null;
            }

            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject resultsJsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONArray locationData = (JSONArray) resultsJsonObject.get("results");
            resultsJsonObject = (JSONObject) locationData.get(0);

            double latitude = (double) resultsJsonObject.get("latitude");
            double longitude = (double) resultsJsonObject.get("longitude");

            return new Coordinates(latitude, longitude);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}