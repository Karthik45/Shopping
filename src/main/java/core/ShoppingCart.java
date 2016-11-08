package core;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> cart;

    public ShoppingCart(){
       this.cart  = new ArrayList<Item>(); //This list consist of the selected item
    }
    double total;

    public double calculateTotalPrice(){ //This calculate the total price of the selected item.

        
        return total;
    }
}
