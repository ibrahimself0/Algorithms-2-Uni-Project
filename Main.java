import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BST bst = new BST();
        AvlTree avlTree = new AvlTree();
        ShipmentTree shipmentTree = new ShipmentTree();

        bst.insert(new Product("Dell XPS 15", 1299.99f, 25));
        bst.insert(new Product("iPhone 14", 999.00f, 50));
        bst.insert(new Product("Sony WH-1000XM4", 349.99f, 30));
        bst.insert(new Product("Logitech MX Keys", 99.95f, 15));

        avlTree.insert(new Product("Dell XPS 15", 1299.99f, 25));
        avlTree.insert(new Product("iPhone 14", 999.00f, 50));
        avlTree.insert(new Product("Sony WH-1000XM4", 349.99f, 30));
        avlTree.insert(new Product("Logitech MX Keys", 99.95f, 15));

        int x;
        do {
            System.out.println("1: Managing Products Using BST");
            System.out.println("2: Managing Products Using AVL");
            System.out.println("3: Managing Shipments Using BST");
            System.out.println("4: Managing Orders Using Heaps");
            System.out.println("5: Quit");
            x = in.nextInt();

            switch (x) {
                case 1 -> {
                    bst.printTree();
                    System.out.println("1: Adding a New Product");
                    System.out.println("2: Searching for a Product Using ID");
                    System.out.println("3: Updating Stock");
                    System.out.println("4: Updating Price");
                    System.out.println("5: Deleting a Product");
                    int y = in.nextInt();
                    switch (y) {
                        case 1 -> {
                            System.out.println("Enter Name, Price, Stock:");
                            String name = in.next();
                            float price = in.nextFloat();
                            int stock = in.nextInt();
                            bst.insert(new Product(name, price, stock));
                        }
                        case 2 -> {
                            System.out.println("Enter ID:");
                            System.out.println(bst.search(in.nextInt()));
                        }
                        case 3 -> {
                            System.out.println("Enter ID and New Stock:");
                            bst.setAvailable(in.nextInt(), in.nextInt());
                        }
                        case 4 -> {
                            System.out.println("Enter ID and New Price:");
                            bst.setPrice(in.nextInt(), in.nextFloat());
                        }
                        case 5 -> {
                            System.out.println("Enter ID:");
                            System.out.println(bst.deleteHelper(in.nextInt()));
                        }
                    }
                }
                case 2 -> {
                    avlTree.printTree();
                    System.out.println("1: Adding a New Product");
                    System.out.println("2: Searching for a Product Using ID");
                    System.out.println("3: Updating Stock");
                    System.out.println("4: Updating Price");
                    int y = in.nextInt();
                    switch (y) {
                        case 1 -> {
                            System.out.println("Enter Name, Price, Stock:");
                            String name = in.next();
                            float price = in.nextFloat();
                            int stock = in.nextInt();
                            avlTree.insert(new Product(name, price, stock));
                        }
                        case 2 -> {
                            System.out.println("Enter ID:");
                            System.out.println(avlTree.search(in.nextInt()));
                        }
                        case 3 -> {
                            System.out.println("Enter ID and New Stock:");
                            avlTree.setAvailable(in.nextInt(), in.nextInt());
                        }
                        case 4 -> {
                            System.out.println("Enter ID and New Price:");
                            avlTree.setPrice(in.nextInt(), in.nextFloat());
                        }
                    }
                }
                case 3 -> {
                    shipmentTree.printInOrder();
                    System.out.println("1: Adding a New Shipment");
                    System.out.println("2: Searching for a Shipment Using ID");
                    System.out.println("3: Updating the Shipment Date");
                    int y = in.nextInt();
                    switch (y) {
                        case 1 -> {
                            ArrayList<Product> products = new ArrayList<>();
                            System.out.println("How many products to add:");
                            int num = in.nextInt();
                            avlTree.printTree();
                            for (int i = 0; i < num; i++) {
                                System.out.println("Enter ID and Quantity:");
                                int id = in.nextInt();
                                int qty = in.nextInt();
                                Product p = avlTree.searchHelper(avlTree.root, id);
                                if (p != null && p.available >= qty) {
                                    p.available -= qty;
                                    products.add(new Product(p.name, p.price, qty));
                                } else {
                                    System.out.println("Invalid ID or stock");
                                }
                            }
                            System.out.println("Enter Destination, Delivery Date:");
                            String dest = in.next();
                            double cost = 0;
                            for (int i = 0; i < num; i++) {
                                cost += products.get(i).price;
                            }
                            String date = in.next();
                            shipmentTree.addShipment(new ShipmentNode(dest,cost, date, products));
                        }
                        case 2 -> {
                            System.out.println("Enter ID:");
                            System.out.println(shipmentTree.searchShipment(in.nextInt()));
                        }
                        case 3 -> {
                            System.out.println("Enter ID and New Date:");
                            shipmentTree.setDate(in.nextInt(), in.next());
                        }
                    }
                }
            }
        } while (x != 5);
    }
}
