import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
    public static void main(String args[]) throws FileNotFoundException{
        BST bst = new BST();
        AvlTree avlTree = new AvlTree();
        ShipmentTree shipmentTree = new ShipmentTree();
        System.out.println("1: Managing Products Using BST");
        System.out.println("2: Managing Products Using AVL");
        System.out.println("3: Managing Shipments Using BST");
        System.out.println("4: Managing Orders Using Heaps");
        System.out.println("5: Quit");
        Scanner in = new Scanner(System.in);
        int x  = in.nextInt();
        while (x != 5){
            switch (x){
                case 1:
                    System.out.println("1:Adding a New Product");
                    System.out.println("2:Searching for a Product Using ID");
                    System.out.println("3:Updating Stock ");
                    System.out.println("4:Updating Price" );
                    System.out.println("5:Deleting a Product");
                    int y = in.nextInt();
                    switch (y){
                        case 1:
                            System.out.println("Enter The Name Of The Product : ");
                            String name = in.next();
                            System.out.println("Enter The Price Of The Product : ");
                            float price1 = in.nextFloat();
                            System.out.println("Enter The Stock Of The Product : ");
                            int stock1 = in.nextInt();
                            Product product = new Product(name,price1,stock1);
                            bst.insert(product);
                            break;
                        case 2:
                            System.out.println("Enter The ID : ");
                            int id1 = in.nextInt();
                            System.out.println(bst.search(id1));
                            break;
                        case 3:
                            System.out.println("Enter The ID : ");
                            int id2 = in.nextInt();
                            System.out.println("Enter New Stock : ");
                            int stock2 = in.nextInt();
                            bst.setAvailable(id2,stock2);
                            break;
                        case 4:
                            System.out.println("Enter The ID : ");
                            int id3 = in.nextInt();
                            System.out.println("Enter New Price : ");
                            float price2 = in.nextFloat();
                            bst.setPrice(id3,price2);
                            break;
                        case 5:
                            System.out.println("Enter The ID : ");
                            int id4 = in.nextInt();
                            System.out.println(bst.deleteHelper(id4));
                            break;
                    }
                    break;

                case 2:
                    System.out.println("1:Adding a New Product");
                    System.out.println("2:Searching for a Product Using ID");
                    System.out.println("3:Updating Stock ");
                    System.out.println("4:Updating Price" );
                    y = in.nextInt();
                    switch (y) {
                        case 1:
                            System.out.println("Enter The Name Of The Product : ");
                            String name = in.next();
                            System.out.println("Enter The Price Of The Product : ");
                            float price1 = in.nextFloat();
                            System.out.println("Enter The Stock Of The Product : ");
                            int stock1 = in.nextInt();
                            avlTree.insert(name, price1, stock1);
                            break;
                        case 2:
                            System.out.println("Enter The ID : ");
                            int id1 = in.nextInt();
                            System.out.println(avlTree.search(id1));

                            break;
                        case 3:
                            System.out.println("Enter The ID : ");
                            int id2 = in.nextInt();
                            System.out.println("Enter New Stock : ");
                            int stock2 = in.nextInt();
                            avlTree.setAvailable(id2, stock2);
                            break;
                        case 4:
                            System.out.println("Enter The ID : ");
                            int id3 = in.nextInt();
                            System.out.println("Enter New Price : ");
                            float price2 = in.nextFloat();
                            avlTree.setPrice(id3, price2);
                            break;
                    }

                    break;

                case 3:
                    System.out.println("1:Adding a New Product");
                    System.out.println("2:Searching for a Product Using ID");
                    y = in.nextInt();
                    switch (y){
                        case 1:
                            System.out.println("Enter The Name Of The Product : ");
                            String name = in.next();
                            System.out.println("Enter The Price Of The Product : ");
                            double price1 = in.nextDouble();
                            System.out.println("Enter The Stock Of The Product : ");
                            int stock1 = in.nextInt();
                            //shipmentTree.addShipment(,name, price1, stock1);
                            break;
                        case 2:
                            System.out.println("Enter The ID : ");
                            int id1 = in.nextInt();
                            System.out.println(avlTree.search(id1));

                            break;


                    }
                    break;

                default:
                    System.out.println("1: Managing Products Using BST");
                    System.out.println("2: Managing Products Using AVL");
                    System.out.println("3: Managing Shipments Using BST");
                    System.out.println("4: Managing Orders Using Heaps");
                    System.out.println("5: Quit");
                    x = in.nextInt();
                    break;


            }
        }
    }
}