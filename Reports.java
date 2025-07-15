import java.time.LocalDate;

public class Reports {
    ShipmentTree shipmentTree; 
    BST bst; 
    float cost=0; 


    public Reports(ShipmentTree shipmentTree,BST bst){
        this.shipmentTree=shipmentTree; 
        this.bst=bst; 
        
    }
    //to check the cost of products on the inventory 
    public void checkInventoryCost(){
        checkInventoryCostHelper(bst.node);
        bst.printTree();
        System.out.println(cost);
    }

    public void checkInventoryCostHelper(Product product) {
    if (product == null){
        return;
    }
    checkInventoryCostHelper(product.left);      
    checkInventoryCostHelper(product.right);    
     cost+=product.price;                
    
    }

    //to check high shipments cost 
    public void checkShipmentsCost(double cost,LocalDate date ){
            checkShipmentsCostHelper(shipmentTree.root, cost,date);
    }
    public void checkShipmentsCostHelper(ShipmentNode shipmentNode,double cost,LocalDate date){
        if (shipmentNode==null) {
            return ; 
        }
        if (shipmentNode.cost>=cost) {
            LocalDate deleviryDate=DateChecking.getLocalDate(shipmentNode.deliveryDate);
            if (deleviryDate.isAfter(date)) {
                System.out.println(shipmentNode.toString());
            }
        }
        checkShipmentsCostHelper(shipmentNode.left, cost,date);
        checkShipmentsCostHelper(shipmentNode.right, cost,date);
        
    }

    //to check the orders(shipments) cost that still on the inventory 
    public void checkOrdersCost(){
        checkOrdersCostHelper(shipmentTree.root);
        System.out.println("the cost is "+cost);
    }
    public void checkOrdersCostHelper(ShipmentNode shipmentNode){
        if (shipmentNode==null) {
            return ; 
        }
        LocalDate currenDate=LocalDate.now(); 
        LocalDate deleviryDate=DateChecking.getLocalDate(shipmentNode.deliveryDate); 
        checkOrdersCostHelper(shipmentNode.left);
        checkOrdersCostHelper(shipmentNode.right);
        if (currenDate.isBefore(deleviryDate)) {
            cost+=shipmentNode.cost; 
            System.out.println(shipmentNode.toString());
        }

    }



    
}
