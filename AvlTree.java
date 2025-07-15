public class AvlTree {
    Product root;
    static public int staticID = 0;
    int maxStorage=1000,currentStorage = 0;

    public Product search(int id){
        return searchHelper(root,id);
    }
    public Product searchHelper(Product product,int id){
        if (product == null || product.id == id ) return product;
        if (id<product.id){
            return searchHelper(product.left,id);
        }else{
            return searchHelper(product.right,id);
        }
    }

    public boolean insert(Product product){
        if (currentStorage + product.available > maxStorage) return false;
        currentStorage+= product.available;
        product.id = staticID;
        staticID++;
        root = insertHelper(root,product);
        return true;


    }
    public Product insertHelper(Product current , Product newProduct){
        if (current==null) {
            return newProduct;
        }
        if (newProduct.id == current.id) return current;
        if (newProduct.id < current.id) {
            current.left=insertHelper(current.left,newProduct);
        }
        else{
            current.right=insertHelper(current.right, newProduct);
        }
        update(current);
        return balance(current);
    }

    public void update(Product product){
        int leftNodeHeight;
         if (product.left == null) {
           leftNodeHeight = -1;
        } else {
           leftNodeHeight = product.left.height;
        }

        int rightNodeHeight;
        if (product.right == null) {
          rightNodeHeight = -1;
        } else {
          rightNodeHeight = product.right.height;
        }
        //Without +1, heights don’t increase up the tree
        product.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        product.bf = rightNodeHeight - leftNodeHeight;
    }

    public Product balance(Product product){
        if (product.bf  == -2){
            if(product.left.bf<=0){
                return leftLeftCase(product);
            }else{
                return leftRightCase(product);
            }
        } else if (product.bf == 2) {
            if (product.right.bf >= 0){
                return rightRightCase(product);
            }else{
                return rightLeftCase(product);
            }

        }
        return product;
    }
    private Product leftLeftCase(Product z) {
        return rightRotation(z);
    }

    private Product leftRightCase(Product z) {
        z.left = leftRotation(z.left);
        return rightRotation(z);
    }

    private Product rightRightCase(Product z) {
        return leftRotation(z);
    }

    private Product rightLeftCase(Product z) {
        z.right = rightRotation(z.right);
        return leftRotation(z);
    }


    public Product leftRotation(Product product){
        Product newParent = product.right;
        product.right = newParent.left;
        newParent.left = product;
        update(product);
        update(newParent);
        return newParent;
    }
    public Product rightRotation(Product product){
        Product newParent = product.left;
        product.left = newParent.right;
        newParent.right = product;
        update(product);
        update(newParent);
        return newParent;
    }
    public void setPrice(int id,float price){
        if (price>=0) {
            searchHelper(root, id).price=price;
        }else{
            System.out.println("wrong price");
        }

    }

    public void setAvailable(int id,int available){
        if (available>=0) {
            searchHelper(root, id).available=available;
        }else{
            System.out.println("wrong available");
        }
    }
    public void printTree() {
        printTreeHelper(root);
    }

    private void printTreeHelper(Product node) {
        if (node == null) return;
        printTreeHelper(node.right);
        System.out.println(node);
        printTreeHelper(node.left);
    }


}
