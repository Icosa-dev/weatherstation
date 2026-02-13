/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop;

import io.github.icosadev.wsdesktop.controller.WeatherDisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        System.out.println("Running WSDesktop...");
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // Initialize scene and stage
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
            // Run display loop to update data
            WeatherDisplayController.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}