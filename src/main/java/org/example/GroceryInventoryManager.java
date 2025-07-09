package org.example;

import java.util.*;

public class GroceryInventoryManager {

    public static String viewInventory(Map<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        }
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            output.append(entry.getKey()).append(" – ").append(entry.getValue()).append(" pcs\n");
        }
        return output.toString();
    }

    public static String addProduct(Map<String, Integer> inventory, String name, int quantity) {
        inventory.put(name, inventory.getOrDefault(name, 0) + quantity);
        return "Product added!";
    }

    public static String checkProduct(Map<String, Integer> inventory, String name) {
        if (inventory.containsKey(name)) {
            return name + " is in stock: " + inventory.get(name);
        } else {
            return name + " is not in stock.";
        }
    }

    public static String updateProduct(Map<String, Integer> inventory, String name, int newQuantity) {
        if (inventory.containsKey(name)) {
            inventory.put(name, newQuantity);
            return "Stock updated!";
        } else {
            return "Product not found.";
        }
    }

    public static String removeProduct(Map<String, Integer> inventory, String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            return "Product removed.";
        } else {
            return "Product not found.";
        }
    }
}