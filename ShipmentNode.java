import java.util.ArrayList;

public class ShipmentNode {
    int id;
    String destination;
    double cost;
    String deliveryDate;
    ArrayList<Product> Products = new ArrayList<>();
    ShipmentNode left, right;

    public ShipmentNode(int id, String destination, double cost, String deliveryDate) {
        this.id = id;
        this.destination = destination;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
        left = right = null;
    }
}
