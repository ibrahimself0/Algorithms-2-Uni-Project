public class Product {

    static int staticId=0;
    int id; 
    String name;
    float price;
    int available;
    Product left,right;

    //Avl Attributes
    int bf;
    int height;

    public Product(String name , float price, int available){
        this.id=staticId++; 
        this.available=available; 
        this.price=price; 
        this.name=name;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", price=" + price + ", id=" + id + ", available=" + available +"]";
    }

    







    
}
