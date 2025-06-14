import java.util.ArrayList;

public class ShipmentNode {
    int id;
    String destination;
    double cost;
    String deliveryDate;
    ArrayList<Product> Products ;
    ShipmentNode left, right;

    public ShipmentNode(String destination, double cost, String deliveryDate,ArrayList<Product> Products ) {     
        this.destination = destination;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
        left = right = null;
        this.Products = Products;
    } 
}
