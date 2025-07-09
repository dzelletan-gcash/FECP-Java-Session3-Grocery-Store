package org.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class GroceryInventoryManagerTest {

    // ------------------ Add Product Scenarios ------------------

    /**
     * Add a new product with a valid quantity
     * "Add 'Banana' with quantity 30. Check if it's added and quantity is correct."
     */
    @Test
    public void testAddNewProductWithValidQuantity() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.addProduct(inventory, "Banana", 30);
        assertEquals("Product added!", result);
        assertEquals(30, inventory.get("Banana"));
    }

    /**
     * Add a product with quantity zero
     * "Add 'Mango' with quantity 0. Check if it stores correctly or should be blocked (depends on your rule)."
     */
    @Test
    public void testAddProductWithZeroQuantity() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.addProduct(inventory, "Mango", 0);
        assertEquals("Product added!", result);
        assertEquals(0, inventory.get("Mango"));
    }

    /**
     * Add a product that already exists
     * "Add 'Milk' with quantity 50. Expect it to overwrite the old value."
     */
    @Test
    public void testAddProductThatAlreadyExists() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Milk", 20);
        String result = GroceryInventoryManager.addProduct(inventory, "Milk", 50);
        assertEquals("Product added!", result);
        assertEquals(70, inventory.get("Milk")); // Adds to existing quantity
    }

    // ------------------ Check Product Scenarios ------------------

    /**
     * Check for an existing product
     * "Check 'Milk'. Expect 'Milk is in stock: 20'."
     */
    @Test
    public void testCheckExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Milk", 20);
        String result = GroceryInventoryManager.checkProduct(inventory, "Milk");
        assertEquals("Milk is in stock: 20", result);
    }

    /**
     * Check for a product that doesn’t exist
     * "Check 'Ice Cream'. Expect 'Product not found.'"
     */
    @Test
    public void testCheckNonExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.checkProduct(inventory, "Ice Cream");
        assertEquals("Ice Cream is not in stock.", result);
    }

    // ------------------ Update Stock Scenarios ------------------

    /**
     * Update an existing product with a valid quantity
     * "Update 'Bread' to 25. Confirm the new quantity is stored."
     */
    @Test
    public void testUpdateExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Bread", 10);
        String result = GroceryInventoryManager.updateProduct(inventory, "Bread", 25);
        assertEquals("Stock updated!", result);
        assertEquals(25, inventory.get("Bread"));
    }

    /**
     * Update a non-existing product
     * "Try updating 'Tofu'. Expect 'Product not found.'"
     */
    @Test
    public void testUpdateNonExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.updateProduct(inventory, "Tofu", 12);
        assertEquals("Product not found.", result);
    }

    // ------------------ Remove Product Scenarios ------------------

    /**
     * Remove an existing product
     * "Remove 'Eggs'. Expect 'Product removed.' and not in the map anymore."
     */
    @Test
    public void testRemoveExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Eggs", 12);
        String result = GroceryInventoryManager.removeProduct(inventory, "Eggs");
        assertEquals("Product removed.", result);
        assertFalse(inventory.containsKey("Eggs"));
    }

    /**
     * Remove a product that doesn't exist
     * "Try to remove 'Pizza'. Expect 'Product not found.'"
     */
    @Test
    public void testRemoveNonExistingProduct() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.removeProduct(inventory, "Pizza");
        assertEquals("Product not found.", result);
    }

    // ------------------ View Inventory Scenarios ------------------

    /**
     * View inventory when it is empty
     * "Expect 'Inventory is empty.'"
     */
    @Test
    public void testViewInventoryWhenEmpty() {
        Map<String, Integer> inventory = new HashMap<>();
        String result = GroceryInventoryManager.viewInventory(inventory);
        assertEquals("Inventory is empty.", result);
    }

    /**
     * View inventory when it has items
     * "Expect to display list of items with correct quantity format."
     */
    @Test
    public void testViewInventoryWhenNotEmpty() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Milk", 10);
        inventory.put("Bread", 5);
        String result = GroceryInventoryManager.viewInventory(inventory);
        assertTrue(result.contains("Milk – 10 pcs"));
        assertTrue(result.contains("Bread – 5 pcs"));
    }
}