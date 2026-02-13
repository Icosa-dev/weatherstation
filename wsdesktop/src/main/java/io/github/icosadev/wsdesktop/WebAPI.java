package io.github.icosadev.wsdesktop;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WebAPI {
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
