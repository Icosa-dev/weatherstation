/**
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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller {
        // Scene elements
        @FXML private Label titleLabel;
        @FXML private Text temperatureText;
        @FXML private Text humidityText;
        @FXML private Text pressureText;

        // Class variables
        private static String city = "NYC";
        private Timeline timeline;

        // Called when the scene is loaded. Constantly
        // calls the update method every minute.
        @FXML
        public void initialize() {
                update();

                timeline = new Timeline(
                                new KeyFrame(Duration.seconds(15), e -> update()));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
        }

        // Updates weather data in each scene element
        private void update() {
                System.out.println("Running updateWeather method for " + city + "...");

                Coordinates cityCoordinates = GeocodingAPI.getCoordinates(city);
                WeatherData weather = WeatherAPI.getWeather(
                                cityCoordinates.longitude, cityCoordinates.latitude);

                titleLabel.setText("Current Weather Statistics for "
                                + weather.getTime() + " at " + city);

                temperatureText.setText(weather.getTemperatureF()
                                + "/" + weather.getTemperature());

                humidityText.setText("" + weather.getRelativeHumidity());
                pressureText.setText("" + weather.getPressure());
        }
}
