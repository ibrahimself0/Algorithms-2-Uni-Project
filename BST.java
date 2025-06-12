class BST {

    static int maxStorage=1000,currentStorage=0; 
    Product node;

    public void insert(String name,float price,int available){
        if (currentStorage+available<=maxStorage && price>0) {
            currentStorage+=available; 
             
             node=insertHelper(node, new Product(name, price, available));
             this.printTree();
        }else if (currentStorage+available>maxStorage) {

             System.out.println("sorry...there is no enough storage");
        }else{
            System.out.println("sorry...wrong price ");
        }
        
    }
    public Product insertHelper(Product current ,Product newProduct){
        if (current==null) {
            return newProduct;
        }
            if (newProduct.id<current.id) {
                current.left=insertHelper(current.left,newProduct);
            }
            else{
                current.right=insertHelper(current.right, newProduct);
            }
        return current;
    }


    public String search(int id){
         if(searchHelper(node, id)==null){
            return "not found";
        };
        return searchHelper(node, id).toString(); 
    }

    public Product searchHelper(Product node, int id) {
    if (node == null || node.id == id) {
        return node;
    }

    if (id < node.id) {
        return searchHelper(node.left, id);
    } else {
        return searchHelper(node.right, id);
    }
    }

    public void setPrice(int id,float price){
        if (price>=0) {
            searchHelper(node, id).price=price; 
        }else{
            System.out.println("wrong price");
        }
        
    }

    public void setAvailable(int id,int available){
        if (available>=0) {
            searchHelper(node, id).available=available; 
        }else{
            System.out.println("wrong available");
        }
    }

     public String delete(int id){
            if (searchHelper(node, id) == null) {
                return "Not found";
            }
            node = deleteHelper(node, id);
            return "Got Deleted";

    }
    public Product deleteHelper(Product node, int id) {
        if (node == null) {
            return null;
        }

        if (id < node.id) {
            node.left = deleteHelper(node.left, id);
        } else if (id > node.id) {
            node.right = deleteHelper(node.right, id);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Product temp = hasSons(node.right);
            node.id = temp.id;
            node.name = temp.name;
            node.price = temp.price;
            node.available = temp.available;
            node.right = deleteHelper(node.right, temp.id);
        }

        return node;
    }


private Product hasSons(Product node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}

public void printTree() {
        printTreeHelper(node);
    }

    private void printTreeHelper(Product node) {
        if (node == null) {

            return;
        }
        printTreeHelper(node.right);
        System.out.println(node);
        printTreeHelper(node.left);
    }






    

   
}