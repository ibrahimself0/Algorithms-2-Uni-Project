import java.util.ArrayList;

public class ShipmentTree {
    ShipmentNode root;
    static int staticID = 0;

    public void addShipment(int id, String destination, double cost, String deliveryDate, ArrayList<Product> products) {
        root = insert(root, id, destination, cost, deliveryDate);
    }

    private ShipmentNode insert(ShipmentNode node, int id, String destination, double cost, String deliveryDate) {
        if (node == null) return new ShipmentNode(id, destination, cost, deliveryDate);
        if (id < node.id) node.left = insert(node.left, id, destination, cost, deliveryDate);
        else if (id > node.id) node.right = insert(node.right, id, destination, cost, deliveryDate);
        return node;
    }


    public ShipmentNode searchShipment(int id) {
        return search(root, id);
    }

    private ShipmentNode search(ShipmentNode node, int id) {
        if (node == null || node.id == id) return node;
        return (id < node.id) ? search(node.left, id) : search(node.right, id);
    }


    public void updateDeliveryDate(int id, String newDate) {
        ShipmentNode node = searchShipment(id);
        if (node != null) {
            node.deliveryDate = newDate;
            System.out.println("the date has been updated  " + id);
        } else {
            System.out.println("shipment is not available.");
        }
    }


    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(ShipmentNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println("ID: " + node.id + ", Destination: " + node.destination +
                    ", Cost: " + node.cost + ", Delivery Date: " + node.deliveryDate);
            inOrder(node.right);
        }
    }

}
