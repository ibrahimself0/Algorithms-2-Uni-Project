import java.util.*;
public class Heap {
    int length;
    int size;
    ArrayList<Order> orders ;

    public Heap(int length, int size) {
        this.length = length;
        this.size = size;
        orders = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            orders.add(null);
        }


    }
    public int left(int i) {
        return 2 * i + 1;
    }
    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i){
        return (i-1)/2;
    }
    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if (l<this.size && this.orders.get(l).priority > this.orders.get(i).priority){
            largest = l;
        }else{
            largest = i;
        }
        if (r<this.size && this.orders.get(r).priority > this.orders.get(largest).priority){
            largest = r;
        }
        if (largest != i){
            Order temp = this.orders.get(largest);
            this.orders.set(largest,this.orders.get(i));
            this.orders.set(i,temp);
            heapify(largest);
        }
    }
    public Order extractMax(){
        if (this.size < 1){
            System.out.println("Storage is Empty");
            return null;
        }
        Order max = this.orders.getFirst();
        this.orders.set(0,this.orders.get(size-1));
        this.size--;
        heapify(0);
        return max;
    }
    public void printPriority() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": Priority " + orders.get(i).priority);
        }
    }

    public void insert(Order key){

        this.size++;
        this.orders.set(this.size - 1,key);
        int i = this.size-1;
        while (i>0 && this.orders.get(parent(i)).priority < this.orders.get(i).priority){
            int parentIndex = parent(i);
            Order temp = this.orders.get(i);
            this.orders.set(i,this.orders.get(parentIndex)) ;
            this.orders.set(parentIndex,temp);
            i = parentIndex;
        }
    }

}
