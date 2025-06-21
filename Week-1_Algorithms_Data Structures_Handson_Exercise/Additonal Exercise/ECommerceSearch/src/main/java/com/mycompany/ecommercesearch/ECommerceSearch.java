package com.mycompany.ecommercesearch;
import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class ECommerceSearch {

    public static Product linearSearch(List<Product> products, String searchName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(searchName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String searchName) {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0, right = sortedList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = sortedList.get(mid).productName.compareToIgnoreCase(searchName);

            if (comparison == 0) {
                return sortedList.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("How many products do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for product " + (i + 1));
            System.out.print("Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            products.add(new Product(id, name, category));
        }

        System.out.print("\nEnter product name to search: ");
        String searchItem = scanner.nextLine();

        System.out.println("\n=== Linear Search ===");
        Product result1 = linearSearch(products, searchItem);
        System.out.println(result1 != null ? "Found: " + result1 : "Product not found");

        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, searchItem);
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found");

        scanner.close();
    }
}
