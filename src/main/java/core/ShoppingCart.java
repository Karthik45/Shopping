package core;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    List<Item> cart;
    double total;


    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }



    public ShoppingCart(){
       this.cart  = new ArrayList<Item>(); //This list consist of the selected item
    }

    public double calculateTotalPrice(){//This calculate the total price of the selected item.

        for(Item item :getCart()){
        total = total+item.getPrice();
        }

        return total;
    }

    public void addItemToList(Item item,int quantity){
        while(quantity > 0)
        {
            cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
            quantity--;
        }
    }
}
