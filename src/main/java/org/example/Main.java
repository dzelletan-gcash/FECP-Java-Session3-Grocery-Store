package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        // Prepopulate
        inventory.put("Milk", 20);
        inventory.put("Bread", 15);
        inventory.put("Eggs", 30);

        while (true) {
            System.out.println("\n--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nCurrent Inventory:");
                    System.out.println(GroceryInventoryManager.viewInventory(inventory));
                    break;

                case "2":
                    System.out.print("Enter product name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQty = Integer.parseInt(scanner.nextLine());
                    System.out.println(GroceryInventoryManager.addProduct(inventory, addName, addQty));
                    break;

                case "3":
                    System.out.print("Enter product name to check: ");
                    String checkName = scanner.nextLine();
                    System.out.println(GroceryInventoryManager.checkProduct(inventory, checkName));
                    break;

                case "4":
                    System.out.print("Enter product name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    int newQty = Integer.parseInt(scanner.nextLine());
                    System.out.println(GroceryInventoryManager.updateProduct(inventory, updateName, newQty));
                    break;

                case "5":
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    System.out.println(GroceryInventoryManager.removeProduct(inventory, removeName));
                    break;

                case "6":
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Choose 1-6.");
            }
        }
    }
}