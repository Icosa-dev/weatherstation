/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GeocodingAPI extends WebAPI {
    public static Coordinates getCoordinates(String city) {
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                city + "&count=1&language=en&format=json";
        
        try {
            HttpURLConnection apiConnection = fetchApiResponse(urlString);

            if (apiConnection.getResponseCode() != 200) {
                System.err.println("Error: Could not connect to API.");
                return null;
            }

            String jsonResponse = readApiResponse(apiConnection);

            JSONParser parser = new JSONParser();
            JSONObject locationData = (JSONObject) parser.parse(jsonResponse);

            double latitude = (double) locationData.get("latitude");
            double longitude = (double) locationData.get("longitude");

            return new Coordinates(latitude, longitude);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}