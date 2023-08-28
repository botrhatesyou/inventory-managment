package com.example.mainapp;

import java.util.ArrayList;

/**
 * The Inventory class manages a list of Brand objects.
 */
public class Inventory {
    private final ArrayList<Brand> items;

    /**
     * Constructor for an Inventory object.
     */
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a Brand object to the inventory.
     * @param brand The Brand object to be added.
     */
    public void add(Brand brand) {
        this.items.add(brand);
    }

    /**
     * Returns the current inventory.
     * @return An ArrayList of Brand objects representing the current inventory.
     */
    public ArrayList<Brand> getItems() {
        return this.items;
    }
}