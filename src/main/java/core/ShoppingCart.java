package core;


import resources.ItemType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<Item> cart,offerItems,finalCart;
    int noOfItems;


    public List<Item> getCart() {
        return cart;
    }

//    public void setCart(List<Item> cart) {
//        this.cart = cart;
//    }



    public ShoppingCart(){
       this.cart  = new ArrayList<Item>();
       this.offerItems = new ArrayList<Item>();
       this.finalCart = new ArrayList<Item>(); //This list consist of the selected item and offeritems
    }

    public double calculateTotalPrice(){//This calculate the total price of the selected item.
        double total = 0.0;
        for(Item item :getCart()){
            total = total+ item.getPrice();
        }
        clubAllCarts();
        return total;
    }

    public void addItemToList(Item item,int quantity){

        if(item.getItemType().equals(ItemType.Milk)){
            offerItems(item,quantity/2);
        }

        while(quantity > 0)
        {
            cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
            quantity--;
        }

    }


    public void shoppingDone(){
        cart.clear();
        offerItems.clear();
        finalCart.clear();
    }

    public void offerItems(Item item,int quantity) {
        while (quantity > 0){
            offerItems.add(item);
            quantity--;
        }
    }
    public List<Item> clubAllCarts(){
        finalCart.addAll(cart);
        finalCart.addAll(offerItems);
        noOfItems = finalCart.size();
        return finalCart;
    }

    public int getNoOfItems(){
        return noOfItems;
    }
}
