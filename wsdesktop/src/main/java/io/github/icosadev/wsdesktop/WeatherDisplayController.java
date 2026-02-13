package io.github.icosadev.wsdesktop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.fxml.FXML;

public class WeatherDisplayController {
    @FXML
    private static String city;
    private static Timeline timeline;

    // Initializer method to start the loop
    public static void init() {
        timeline = new Timeline(
            // DO NOT HAVE IT UPDATE EVERY SECOND
            // when it actually calls the API
            new KeyFrame(Duration.seconds(1), e -> updateWeather())
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    // Loop to update weather data
    private static void updateWeather() {
        System.out.println("TEST");
    }

    public static void setCity(String aCity) {
        city = aCity;
    }
}