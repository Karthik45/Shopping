package core;


import Builder.ItemsBuilder;
import resources.ItemType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    Item item;
    private List<Item> cart;


    public List<Item> getCart() {
        return cart;
    }

    public ShoppingCart() {
        this.cart = new ArrayList<Item>(); //This list consist of the selected item and offeritems
        item = new Item();
    }

    public double calculateTotalPrice() {//This calculate the total price of the selected item.
        double total = 0.0;
        for (Item item : getCart()) {
            if(!item.isFree())
            total = total + item.getPrice();
        }
        return total;

    }

    public void addItemToList(ItemType itemType, int quantity, double price) {

        for (int i = quantity; i > 0; i--) {
            item = new ItemsBuilder().withItems(itemType).withPrice(price).build();
            cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
        }

        if (itemType.equals(ItemType.Milk)) {
            int freeQuantity = quantity / 2;
            addFreeItemToCart(itemType, freeQuantity);
        }

    }

    public void shoppingDone() {

        cart.clear();
    }

    public int getNoOfItems() {
        return cart.size();
    }

    public void addFreeItemToCart(ItemType itemType, int quantity) {

        for (int i = quantity; i > 0; i--) {
            Item freeItem = new ItemsBuilder().withItems(itemType).withOffer(true).build();
            cart.add(freeItem);

        }
    }
}


