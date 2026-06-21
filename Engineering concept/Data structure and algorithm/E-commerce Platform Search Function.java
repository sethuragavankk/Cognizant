import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "ID: " + productId +
               ", Name: " + productName +
               ", Category: " + category;
    }
}

public class Main {
    public static Product linearSearch(Product[] products, int key) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == key) {
                return products[i];
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, int key) {
        int low = 0;
        int high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == key) {
                return products[mid];
            }
            if (key < products[mid].productId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Shoes", "Fashion"),
            new Product(105, "Watch", "Accessories")
        };

        int searchId = 104;

        Product result1 = linearSearch(products, searchId);

        System.out.println("Linear Search:");
        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product not found");

        Product result2 = binarySearch(products, searchId);

        System.out.println("\nBinary Search:");
        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product not found");
    }
}
