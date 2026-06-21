import java.util.*;
class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: ₹" + price;
    }
}
class InventoryManager {
    private Map<Integer, Product> inventory;
    public InventoryManager() {
        inventory = new HashMap<>();
    }
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }
    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void searchProduct(int productId) {
        Product product = inventory.get(productId);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\nInventory Details:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new Product(101, "Laptop", 10, 50000));
        manager.addProduct(new Product(102, "Mouse", 50, 500));
        manager.addProduct(new Product(103, "Keyboard", 30, 1500));
        
        manager.displayInventory();
        
        
        manager.updateProduct(102, "Wireless Mouse", 45, 700);
       
       
        System.out.println("\nSearching Product ID 102:");
        manager.searchProduct(102);

        
        manager.deleteProduct(103);

        System.out.println("\nInventory After Deletion:");
        manager.displayInventory();
    }
}