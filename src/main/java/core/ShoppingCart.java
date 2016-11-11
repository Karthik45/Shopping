package core;


import resources.ItemType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {


  Item item = new Item();
    private List<Item> cart;
    int noOfItems,count=0;;

    public List<Item> getCart() {
        return cart;
    }

    public ShoppingCart(){
       this.cart  = new ArrayList<Item>();
                                       //This list consist of the selected item and offeritems
    }

    public double calculateTotalPrice(){//This calculate the total price of the selected item.
        double total = 0.0;
        for(Item item :getCart()){
            total = total+ item.getPrice();
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
    public void shoppingDone(){
        cart.clear();
    }


//    public List<Item> clubAllCarts(){
//        finalCart.addAll(cart);
//        finalCart.addAll(offerItems);
//        noOfItems = finalCart.size();
//        return finalCart;
//    }


    public int getNoOfItems(){
        noOfItems = cart.size();
        return noOfItems;
    }

    public void applyOffer(){

            int frequency;
            frequency = Collections.frequency(cart, item.getItemType().equals(ItemType.Milk));

            frequency = frequency/2;

            while(frequency > 0){
                cart.add(item);
            }
    }
}


