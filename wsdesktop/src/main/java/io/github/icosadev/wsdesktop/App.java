/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop;

import io.github.icosadev.wsdesktop.api.Coordinates;
import io.github.icosadev.wsdesktop.api.GeocodingAPI;
import io.github.icosadev.wsdesktop.api.WeatherAPI;
import io.github.icosadev.wsdesktop.api.WeatherData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    private static String city;
    private static Timeline timeline;

    @FXML
    private static Label titleLabel;
    private static Text temperatureText;
    private static Text humidityText;
    private static Text pressureText;

    public static void main(String[] args) {
        System.out.println("Running WSDesktop...");
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // Class variables
            if (city == null) {
                city = "NYC"; // Default to NYC
            }

            // Initialize scene and stage
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            // Update loop logic
            update();

            timeline = new Timeline(
                new KeyFrame(Duration.minutes(1), e -> update()));

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void update() {
        System.out.println("Running updateWeather method for " + city + "...");

        Coordinates cityCoordinates = GeocodingAPI.getCoordinates(city);
        System.out.println("cityCoordinates: " + cityCoordinates.toString());

        WeatherData weather = WeatherAPI.getWeather(
                cityCoordinates.longitude, cityCoordinates.latitude);
        System.out.println("weather: " + weather.toString());

        titleLabel.setText("Current Weather Statistics for "
                + weather.getTime() + " at " + city);

        temperatureText.setText(weather.getTemperatureF()
                + "/" + weather.getTemperature());

        humidityText.setText("" + weather.getRelativeHumidity());

        pressureText.setText("" + weather.getPressure());
    }
}