/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class WeatherDisplayController {
    @FXML
    private static String city;
    private static Timeline timeline;
    
    private static Label titleLabel;

    private static Text temperatureText;
    private static Text humidityText;
    private static Text pressureText;

    // Initializer method to start the loop
    public static void init() {
        timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> updateWeather())
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    // Loop to update weather data
    private static void updateWeather() {
        System.out.println("Printing from WeatherDisplayController...");
        // TODO: Implement this
    }

    public static void setCity(String aCity) {
        city = aCity;
    }
}