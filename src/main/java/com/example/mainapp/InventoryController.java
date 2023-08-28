package com.example.mainapp;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * The InventoryController class acts as the controller for the inventory management application.
 * It handles user interactions, updates the model (Inventory), and updates the view (InventoryView) accordingly.
 */
public class InventoryController {
    private Inventory inventory;
    private InventoryView view;

    /**
     * Constructor for the InventoryController class.
     * @param inventory The Inventory object.
     * @param view The InventoryView object.
     */
    public InventoryController(Inventory inventory, InventoryView view) {
        this.inventory = inventory;
        this.view = view;

        // Set up event handlers for the brand combo box and add button
        view.getBrandComboBox().setOnAction(e -> updateTypeComboBox());
        view.getAddButton().setOnAction(e -> addToInventory());
    }

    /**
     * Updates the type combo box based on the selected brand.
     */
    private void updateTypeComboBox() {
        String brand = view.getBrandComboBox().getValue();
        if (brand == null) {
            view.getTypeComboBox().getItems().clear();
        } else if (brand.equals("Primal")) {
            view.getTypeComboBox().setItems(FXCollections.observableArrayList("beef", "chicken", "lamb", "pork"));
        } else if (brand.equals("Naturawls")) {
            view.getTypeComboBox().setItems(FXCollections.observableArrayList("chicken", "beef", "lamb", "turkey", "fish"));
        } else if (brand.equals("SC")) {
            view.getTypeComboBox().setItems(FXCollections.observableArrayList("beef", "chicken", "lamb", "duck", "venison"));
        }
    }

    /**
     * Adds a new brand to the inventory based on the user input.
     */
    private void addToInventory() {
        try {
            String name = view.getBrandComboBox().getValue();
            String type = view.getTypeComboBox().getValue();
            double weight = Double.parseDouble(view.getWeightField().getText().trim());
            int quantity = Integer.parseInt(view.getQuantityField().getText().trim());

            // Validate input values
            if (name == null || name.isEmpty()) {
                showError("Brand name cannot be empty.");
                return;
            }

            if (type == null || type.isEmpty()) {
                showError("Food type cannot be empty.");
                return;
            }

            if (weight <= 0) {
                showError("Weight must be a positive number.");
                return;
            }

            if (quantity <= 0) {
                showError("Quantity must be a positive number.");
                return;
            }

            // Create a new Brand object and add it to the inventory
            Brand brand = new Brand(name, type, weight, quantity);
            inventory.add(brand);
            updateInventoryArea();

            // Clear the input fields
            view.getWeightField().clear();
            view.getQuantityField().clear();

            writeInventoryToFile();
        } catch (NumberFormatException e) {
            showError("Invalid weight or quantity. Please enter a valid number.");
        }
    }

    /**
     * Updates the inventory display in the text area.
     */
    private void updateInventoryArea() {
        StringBuilder sb = new StringBuilder();
        for (Brand brand : inventory.getItems()) {
            sb.append(brand).append("\n");
        }
        view.getInventoryArea().setText(sb.toString());
    }

    /**
     * Displays an error message using an Alert dialog.
     * @param message The error message to be displayed.
     */
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void writeInventoryToFile() {
        String fileName = LocalDate.now() + "-inventory.txt"; // Name the file with the current date
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Brand brand : inventory.getItems()) {
                writer.write(brand.toString());
                writer.newLine(); // Write each brand on a new line
            }
        } catch (IOException e) {
            showError("Error writing to file: " + e.getMessage());
        }
    }
}