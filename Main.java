import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import out.SecondProblem.ForSecond;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BST bst = new BST();
        AvlTree avlTree = new AvlTree();
        ShipmentTree shipmentTree = new ShipmentTree();
        Heap heap = new Heap(15,0);

        bst.insert("Dell XPS 15", 1299.99f, 25);
        bst.insert("iPhone 14", 999.00f, 50);
        bst.insert("Sony WH-1000XM4", 349.99f, 30);
        bst.insert("Logitech MX Keys", 99.95f, 15);
        
        avlTree.insert(new Product("Dell XPS 15", 1299.99f, 25));
        avlTree.insert(new Product("iPhone 14", 999.00f, 50));
        avlTree.insert(new Product("Sony WH-1000XM4", 349.99f, 30));
        avlTree.insert(new Product("Logitech MX Keys", 99.95f, 15));

        heap.insert(new Order(2, List.of(
                new Product("Lenovo ThinkPad X1", 1599.99f, 14),
                new Product("Google Pixel 7", 699.00f, 30),
                new Product("Anker Soundcore Q45", 149.99f, 28),
                new Product("Keychron K8", 89.99f, 20)
        )));

        heap.insert(new Order(10, List.of(
                new Product("Dell XPS 15", 1299.99f, 25),
                new Product("iPhone 14", 999.00f, 50),
                new Product("Sony WH-1000XM4", 349.99f, 30),
                new Product("Logitech MX Keys", 99.95f, 15)
        )));

        heap.insert(new Order(200, List.of(
                new Product("MacBook Pro 16", 2399.99f, 10),
                new Product("iPad Air", 599.00f, 20),
                new Product("Bose QC45", 329.00f, 25),
                new Product("Magic Keyboard", 99.00f, 12)
        )));

        heap.insert(new Order(1, List.of(
                new Product("HP Spectre x360", 1399.00f, 18),
                new Product("Samsung Galaxy S22", 849.00f, 35),
                new Product("Jabra Elite 85t", 229.99f, 22),
                new Product("Razer DeathAdder V2", 69.99f, 40)
        )));

        int x;
        do {
            System.out.println("1: Managing Products Using BST");
            System.out.println("2: Managing Products Using AVL");
            System.out.println("3: Managing Shipments Using BST");
            System.out.println("4: Managing Orders Using Heaps");
            System.out.println("5: Reports About Shipments And Products");
            System.out.println("6: Quit");
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
                            bst.insert(name, price, stock);
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
                            System.out.println(bst.delete(in.nextInt()));
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
                            double cost =0; 
                            for (int i = 0; i < num; i++) {
                                cost += products.get(i).price;
                            }
                            String date = in.next();

                            if (DateChecking.check(date)&&cost>0) {
                                shipmentTree.addShipment(new ShipmentNode(dest,cost, date, products));
                            }else if (DateChecking.check(date)==false) {
                                System.out.println("invalid date ");
                            }else if(cost<0){
                                System.out.println("wrong cost ");
                            }

                            
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
                case 4-> {
                    System.out.println("1: Adding new Order");
                    System.out.println("2: Get Max Priority");
                    System.out.println("3: Change Order Priority");
                    int y = in.nextInt();
                    switch (y){
                        case 1->{
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
                            System.out.println("Do You Want Rush Order 1 For Yes / 0 For No");
                            int priority;
                            int ans = in.nextInt();
                            if (ans == 1){
                                priority = heap.size > 0 ? heap.orders.getFirst().priority + 1 : 1;
                            }else{
                                System.out.println("Enter The Product Priority");
                                priority = in.nextInt();
                            }
                            heap.insert(new Order(priority,products));
                        }
                        case 2-> {
                            if (heap.size > 0){
                                System.out.println(heap.extractMax().priority);
                            }else{
                                System.out.println("Heap Is Empty");
                            }
                        }
                        case 3->{
                            // Working on it
                            heap.printPriority();
                            System.out.println("Enter The Index Of The Priority Of The Product You Want To Change : ");
                            int ans = in.nextInt();
                            System.out.println("Enter The New Priority : ");
                            heap.orders.get(ans).priority = in.nextInt();
                            heap.heapify((ans -1) /2);

                            heap.printPriority();

                        }
                        

                    }
                    

                }
                case 5->{
                    Reports reports=new Reports(shipmentTree, bst); 
                    System.out.println("1:for inventory cost ");
                    System.out.println("2:for high cost shipments");
                    System.out.println("3:for cost of shipments ");
                    int report=in.nextInt(); 
                    switch (report) {
                        case 1:{
                            reports.checkInventoryCost();
                        }break; 
                        case 2:{
                            System.out.println("enter the date ");
                            String stringDate=in.nextLine(); 
                            stringDate=in.nextLine(); 
                            LocalDate date=DateChecking.getLocalDate(stringDate); 
                            System.out.println("enter what the high cost you want ");
                            double cost=in.nextInt(); 
                            reports.checkShipmentsCost(cost, date);
                        }break; 
                        case 3:{
                            reports.checkOrdersCost();
                        }
                        default:
                            break;
                    }
                }
                
                
            }

        } while (x != 6);
        
}

}
