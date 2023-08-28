
package com.example.mainapp;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The InventoryView class creates the graphical user interface (GUI) for the inventory management application.
 */
public class InventoryView {
    private ComboBox<String> brandComboBox = new ComboBox<>();
    private ComboBox<String> typeComboBox = new ComboBox<>();
    private TextField weightField = new TextField();
    private TextField quantityField = new TextField();
    private TextArea inventoryArea = new TextArea();
    private Button addButton = new Button("Add to Inventory");
    private Stage primaryStage = new Stage();

    /**
     * Constructor for the InventoryView class.
     * Sets up the GUI components and displays the main stage.
     */
    public InventoryView() {
        primaryStage.setTitle("Pet Food Inventory Manager");

        // Set up the brand combo box with predefined options
        brandComboBox.setItems(FXCollections.observableArrayList("Primal", "Naturawls", "SC"));

        // Create a grid pane to organize the UI components
        GridPane grid = new GridPane();
        grid.add(new Label("Brand Name:"), 0, 0);
        grid.add(brandComboBox, 1, 0);
        grid.add(new Label("Food Type:"), 0, 1);
        grid.add(typeComboBox, 1, 1);
        grid.add(new Label("Weight (lbs):"), 0, 2);
        grid.add(weightField, 1, 2);
        grid.add(new Label("Quantity:"), 0, 3);
        grid.add(quantityField, 1, 3);
        grid.add(addButton, 0, 4);

        // Set up the inventory display area
        inventoryArea.setEditable(false);
        VBox vbox = new VBox(10, grid, inventoryArea);

        // Set the main stage and show it
        primaryStage.setScene(new Scene(vbox, 500, 500));
        primaryStage.show();
    }

    // Getter methods for accessing the UI components

    public ComboBox<String> getBrandComboBox() {
        return brandComboBox;
    }

    public ComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }

    public TextField getWeightField() {
        return weightField;
    }

    public TextField getQuantityField() {
        return quantityField;
    }

    public TextArea getInventoryArea() {
        return inventoryArea;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}