/**
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.weatherstation.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Provides shared functionality for API service classes that retrieve
 * and process JSON data over HTTP.
 * 
 * @author LJC
 * @since 1.0
 */
public abstract class WebAPI {
    /**
     * Creates a connection to the API via the URL provided.
     * 
     * @param urlString the fully qualified URL of the API endpoint
     * @return an active HTTP connection to the specified URL,
     *         or {@code null} if the connection attempt fails
     * @since 1.0
     */
    protected static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Reads the response data from an established HTTP connection
     * and returns it as a {@link #String}.
     * 
     * @param apiConnection the active HTTP connection to the API
     * @return the response body as a String
     * @since 1.0
     */
    protected static String readApiResponse(HttpURLConnection apiConnection) {
        try {
            StringBuilder resultJson = new StringBuilder();

            Scanner scanner = new Scanner(apiConnection.getInputStream());

            while (scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }

            scanner.close();

            return resultJson.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
