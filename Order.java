import java.util.ArrayList;
import java.util.List;

public class Order {
    int priority;
    List<Product> products ;

    public Order(int priority, List<Product> products) {
        this.priority = priority;
        this.products = new ArrayList<>(products);
    }
}
