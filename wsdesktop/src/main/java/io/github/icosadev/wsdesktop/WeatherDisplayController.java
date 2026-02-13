package io.github.icosadev.wsdesktop;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class WeatherDisplayController {
    @FXML
    private static String city;
    private static Timeline timeline;
    
    private static Label titelLabel;
    private static TitledPane temperaturePane;
    private static TitledPane humidityPane;
    private static TitledPane pressurePane;
    private static TitledPane windSpeedPane; 

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