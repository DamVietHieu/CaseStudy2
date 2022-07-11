package CaseModule2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
        ArrayList<product.Product> products;
        Scanner scanner;

        public ProductManager() {
                products = new ArrayList<>();
                scanner = new Scanner(System.in);
        }

        public void InsertProduct() {
                try {
                        System.out.println("Id product: ");
                        String id = scanner.nextLine();
                        while (checkID(id)) {
                                System.out.println("Id invalid!");
                                System.out.println("Input again Product id: ");
                                id = scanner.nextLine();
                        }
                        System.out.println("Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Price: ");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.println("amount: ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        System.out.println("describe: ");
                        String describe = scanner.nextLine();
                        product.Product product = new product.Product(id, name, price, amount, describe);
                        products.add(product);
                        System.out.println("insert Sugessted!");
                } catch (Exception e) {
                        System.out.println("Illegal!");
                        System.out.println("Please retype!.");
                        InsertProduct();
                }
        }

        public void updateProduct(product.Product product) {
                try {
                        System.out.println("New product id: ");
                        String id = scanner.nextLine();
                        while (checkID(id)) {
                                System.out.println("Id invalid!");
                                System.out.println("Retype Product Id: ");
                                id = scanner.nextLine();
                        }
                        System.out.println("Update name: ");
                        String name = scanner.nextLine();
                        System.out.println("Update price: ");
                        int price = Integer.parseInt(scanner.nextLine());
                        System.out.println("Update amount : ");
                        int amount = Integer.parseInt(scanner.nextLine());
                        System.out.println("update describe: ");
                        String describe = scanner.nextLine();
                        product.setId(id);
                        product.setName(name);
                        product.setPrice(price);
                        product.setAmount(amount);
                        product.setDescribe(describe);
                        System.out.println("Update sugessted!");
                } catch (Exception e) {
                        System.out.println("Illegal!");
                        System.out.println("Please retype!.");
                        updateProduct(product);
                }
        }

        public void deleteProduct(product.Product product) {
                System.out.println("Do you want delete this product ?");
                System.out.println("Y: Yes!");
                System.out.println("Enter any character to escape!");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                        products.remove(product);
                        System.out.println("Delete Sugessted!");
                }
        }
        public ArrayList<product.Product> sortByIncrementalPrice() {
                Collections.sort(products);
                return products;
        }

        public ArrayList<product.Product> sortByDescendPrice() {
                ArrayList<product.Product> newProducts = sortByIncrementalPrice();
                Collections.reverse(newProducts);
                return newProducts;
        }

        public product.Product searchById(String id) {
                for (CaseModule2.product.Product product : products) {
                        if (product.getId().equals(id)) {
                                return product;
                        }
                }
                return null;
        }

        public product.Product searchMaxPrice() {
                ArrayList<product.Product> productArrayList = sortByIncrementalPrice();
                return productArrayList.get((productArrayList.size() - 1));
        }
        public void displayAll() {
                for (CaseModule2.product.Product product : products) {
                        System.out.println(product);
                }
        }
        public void displayProduct(product.Product product) {
                System.out.println(product);
        }

        public boolean checkID(String id) {
                for (CaseModule2.product.Product product : products) {
                        if (product.getId().equals(id)) {
                                return true;
                        }
                }
                return false;
        }
}



