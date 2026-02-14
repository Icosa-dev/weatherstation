/**
 * Copyright (c) 2026 LJC
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

package io.github.icosadev.wsdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    // JavaFX start
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/Main.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    // Application entry point
    public static void main(String[] args) {
        launch(args);
    }
}