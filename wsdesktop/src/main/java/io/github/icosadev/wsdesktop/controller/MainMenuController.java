/*
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController {
    @FXML
    private static String clickedButtonId;
    private static Button localButton;
    private static Button globalButton;
    private static TextField cityTextField;

    public void handleButton(ActionEvent event) {
        // Get ID of clicked button
        Button clickedButton = (Button) event.getSource();
        clickedButtonId = clickedButton.getText();
        System.out.println(clickedButtonId);

        // Set the city for the controller class of the
        // next scene
        if (cityTextField != null)
            WeatherDisplayController.setCity(cityTextField.getText());
        else {
            System.out.println("CITY TEXT FIELD NULL");
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/WeatherDisplay.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            WeatherDisplayController.init();
            stage.show();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    public static String getClickedButtonId() {
        return clickedButtonId;
    }
}
