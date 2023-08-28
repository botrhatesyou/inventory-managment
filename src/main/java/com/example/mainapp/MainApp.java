package com.example.mainapp;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The MainApp class is the entry point for the application.
 * It extends the Application class from JavaFX and sets up the initial stage.
 */
public class MainApp extends Application {
    /**
     * The main method launches the JavaFX application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create an instance of Inventory and InventoryView
        Inventory inventory = new Inventory();
        InventoryView view = new InventoryView();

        // Create an instance of InventoryController to handle user interactions
        new InventoryController(inventory, view);
    }
}