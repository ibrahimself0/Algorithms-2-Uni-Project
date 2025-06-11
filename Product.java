public class Product {

    String name;
    float price;
    int id,available;
    Product left,right;

    //Avl Attributes
    int bf;
    int height;

    public Product(String name , float price, int available, int id){
        this.available=available; 
        this.price=price; 
        this.name=name; 
        this.id=id; 
        
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Products [name=" + name + ", price=" + price + ", id=" + id + ", available=" + available +"]";
    }

    







    
}
