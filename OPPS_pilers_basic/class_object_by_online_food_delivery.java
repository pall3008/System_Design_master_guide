import java.util.ArrayList;
import java.util.List;

// class template Food order
class FoodOrder{
    // attribute
    private String orderId;
    private String customerName;
    private List<String> items;
    private double TotalAmount;
    private boolean isPlaced;
    //  constructor
    public FoodOrder(String orderId,String customerName){
         this.orderId = orderId;
         this.customerName = customerName;
    }
    // methods

    // only allow to add items before the order is placed

    public void addItem(String name , double price){
        if(isPlaced){
             System.out.println("cannot modify a placed order");
             return ;
        }
        items.add(name);
        
        TotalAmount +=price;
    }

    // placed the whern it have atleast one item or have not palced yet
    public boolean placeOrder(){
         if(isPlaced || items.isEmpty()) return false;

         isPlaced = true;
         return true;

    }

    public int getItemsCount(){
         return items.size();
    }

    public void display(){
         String status = isPlaced ? "PLACED" : "PENDING";
          System.out.println("Order " + orderId + " (" + customerName + ") - " + status);
        for (String item : items) {
            System.out.println("  - " + item);
        }
        System.out.printf("  Total: $%.2f%n", TotalAmount);
    }
};

public class class_object_by_online_food_delivery {
       public static void main(String []args){
          FoodOrder order1 = new FoodOrder("ORD-1001","pallvi");
          order1.addItem("pizza", 300);
          order1.addItem("Garlic Bread", 199.8);
          order1.placeOrder();
          order1.display();

       }
}