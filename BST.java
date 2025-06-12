class BST {
    static int staticID = 0;

    int maxStorage=1000,currentStorage=0;
    Product node;

    public void insert(Product newProduct){
        if (currentStorage+newProduct.available<=maxStorage) {
            newProduct.id = staticID;
            staticID++;
            currentStorage += newProduct.available;
            node=insertHelper(node, newProduct);
        }else{
            System.out.println("sorry there is no enough storage");
        }

    }
    public Product insertHelper(Product current , Product newProduct){
        if (current==null) {
            return newProduct;
        }
        if (newProduct.id == current.id) return current;

        if (newProduct.id<current.id) {
            current.left=insertHelper(current.left,newProduct);
        }
        else{
            current.right=insertHelper(current.right, newProduct);
        }
        return current;
    }


    public String search(int id){
        Product res = searchHelper(node, id);
        if(res == null){
            return "not found";
        }
        return "product found : "+res.toString();
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
    public String deleteHelper(int id){
            if (searchHelper(node, id) == null) {
                return "Not found";
            }
            node = delete(node, id);
            return "Got Deleted";

    }
    public Product delete(Product node, int id) {
        if (node == null) {
            return null;
        }

        if (id < node.id) {
            node.left = delete(node.left, id);
        } else if (id > node.id) {
            node.right = delete(node.right, id);
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
            node.right = delete(node.right, temp.id);
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