
package com.nitish.inventory_management_system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter product name: ");
                    String product_name=sc.nextLine();

                    System.out.print("Enter product price: ");
                   double product_price=sc.nextDouble();

                    System.out.print("Enter product quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(0, product_name,quantity,product_price);
                    dao.addProduct(product);
                    break;

                case 2:
                    dao.displayAllProducts();
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int searchId = sc.nextInt();

                    dao.searchProductById(searchId);
                    break;

                case 4:
                    System.out.print("Enter product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new product name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new product price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter new product quantity: ");
                    int newQuantity = sc.nextInt();

                    dao.updateProduct(
                            updateId, newName, newPrice, newQuantity
                    );
                    break;

                case 5:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
