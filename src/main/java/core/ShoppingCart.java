package core;


import Builder.ItemsBuilder;
import resources.ItemType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<Item> cart;

    public List<Item> getCart() {
        return cart;
    }

    public ShoppingCart() {
        this.cart = new ArrayList<Item>(); //This list consist of the selected item and offeritems
    }

    public double calculateTotalPrice() {//This calculate the total price of the selected item.
        double total = 0.0;
        for (Item item : getCart()) {
            if (!item.isFree()) {
                total = total + item.getPrice();
            }
        }
        return total;
    }

    public void addItemToList(ItemType itemType, int quantity, double price) {

        addFreeItemToCart(itemType, quantity);

        for (int i = quantity; i > 0; i--) {
            Item item = new ItemsBuilder().withItems(itemType).withPrice(price).build();
            cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
        }
    }

    public void shoppingDone() {
        cart.clear();
    }

    public int getNoOfItems() {
        return cart.size();
    }

    private void addFreeItemToCart(ItemType itemType, int quantity) {

        if (itemType.equals(ItemType.Milk)) {
            int freeQuantity = quantity / 2;
            for (int i = freeQuantity; i > 0; i--) {
                Item freeItem = new ItemsBuilder().withItems(itemType).withOffer(true).build();
                cart.add(freeItem);
            }
        }
    }

    public void removeItemFromList(ItemType itemType, int quantity) {
        int paidItems = calculateItems(itemType, "paid");
        int count = quantity;
        if (count <= paidItems) {
            removeItems(itemType, quantity,"paid");
        }
        if (itemType.equals(ItemType.Milk)) {
            int offerItems = calculateItems(itemType, "free");
            int finalOfferItems = (paidItems - count) / 2;
            int remItems = (offerItems - finalOfferItems);
            removeItems(itemType,remItems,"free");
        }

    }

    private int calculateItems(ItemType itemType, String type) {
        int count = 0;
        if (type.equals("paid")) {
            for (Item item : cart) {
                if (item.getItemType().equals(itemType)) {
                    if (!item.isFree()) {
                        count++;
                    }
                }
            }
        } else if (type.equals("free")) {
            for (Item item : cart) {
                if (item.getItemType().equals(itemType)) {
                    if (item.isFree()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private void removeItems(ItemType itemType, int quantity, String type) {
        List<Item> tempCart = new ArrayList<Item>();
        tempCart.addAll(cart);
        if (type.equals("paid")) {
            for (Item item : cart) {
                if (item.getItemType().equals(itemType) && quantity > 0) {
                    if (!item.isFree()) {
                        int index = cart.indexOf(item);
                        tempCart.remove(index);
                        quantity--;
                    }
                }
            }
        } else if (type.equals("free")) {
            for (Item item : cart) {
                if (item.getItemType().equals(itemType) && quantity > 0) {
                    if (item.isFree()) {
                        int index = cart.indexOf(item);
                        tempCart.remove(index);
                        quantity--;
                    }
                }
            }
        }
        cart.clear();
        cart.addAll(tempCart);
        tempCart.clear();
    }


}


