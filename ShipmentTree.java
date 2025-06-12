public class ShipmentTree {
    ShipmentNode root;
    static int staticID = 0;
    public void addShipment(ShipmentNode shipmentNode) {
        shipmentNode.id = staticID;
        staticID++;
        root = insert(root,shipmentNode);
    }

    public ShipmentNode insert(ShipmentNode current , ShipmentNode newShipment){
        if (current==null) {
            return newShipment;
        }
        if (newShipment.id == current.id) return current;

        if (newShipment.id<current.id) {
            current.left=insert(current.left,newShipment);
        }
        else{
            current.right=insert(current.right, newShipment);
        }
        return current;
    }


    public String searchShipment(int id) {
        ShipmentNode res = search(root, id) ;
        if(res == null){
            return "Not Found";
        }
        return res.toString();
    }

    private ShipmentNode search(ShipmentNode node, int id) {
        if (node == null || node.id == id) return node;
        return (id < node.id) ? search(node.left, id) : search(node.right, id);
    }


    public void setDate(int id,String date){
            search(root, id).deliveryDate = date;
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
