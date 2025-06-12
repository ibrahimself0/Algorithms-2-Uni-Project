public class Product {

    String name;
    float price;
    int id,available;
    Product left,right;

    //Avl Attributes
    int bf;
    int height;

    public Product(String name , float price, int available){
        this.available=available; 
        this.price=price; 
        this.name=name;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", price=" + price + ", id=" + id + ", available=" + available +"]";
    }

    







    
}
