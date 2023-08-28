package com.example.mainapp;

/**
 * The Brand class represents a brand of pet food.
 */
public class Brand {
    private String name;
    private String type;
    private double weight;
    private int quantity;

    /**
     * Constructor for a Brand object.
     * @param name The brand's name.
     * @param type The type of pet food.
     * @param weight The weight of the pet food in pounds.
     * @param quantity The quantity of the pet food.
     */
    public Brand(String name, String type, double weight, int quantity){
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.quantity = quantity;
    }

    /**
     * Getter for the brand's name.
     * @return The brand's name.
     */
    public String getName(){
        return name;
    }

    /**
     * Setter for the brand's name.
     * @param name The brand's name.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns a string representation of the Brand object.
     * @return A string containing the brand's name, type, weight, and quantity.
     */
    public String toString() {
        return name + ", Type: " + type + ", Weight: " + weight + " lbs"+", Quantity: " + quantity;
    }
}