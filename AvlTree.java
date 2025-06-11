public class AvlTree {
    Product root;
    int maxStorage=1000,currentStorage = 0;

    public String search(int id){
        Product res = searchHelper(root,id);
        if (res == null){
            return "Product not  found";
        }
        return res.toString();
    }
    public Product searchHelper(Product product,int id){
        if (product == null || product.id == id ) return product;
        if (product.id<id){
            return searchHelper(product.left,id);
        }else{
            return searchHelper(product.right,id);
        }
    }

    public boolean insert(Product product, String name,float price,int available,int id ){
        if (currentStorage >= maxStorage) return false;
        if (searchHelper(root,product.id) == null){
            root = insertHelper(root,new Product(name,price,available,id));
            currentStorage++;
            return true;
        }
        return false;
    }
    public Product insertHelper(Product current , Product newProduct){
        if (current==null) {
            return newProduct;
        }
        if (newProduct.id<current.id) {
            current.left=insertHelper(current.left,newProduct);
        }
        else{
            current.right=insertHelper(current.right, newProduct);
        }
        update(current);
        return balance(current);
    }

    public void update(Product product){
        int leftNodeHeight = (product.left == null) ? -1 : product.left.height;
        int rightNodeHeight = (product.right == null) ? -1 : product.right.height;
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


}
