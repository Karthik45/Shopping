package core;


import builder.ItemsBuilder;
import resources.ItemType;
import java.util.*;
import java.util.stream.*;

import java.util.ArrayList;
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

        addFreeItemToCart(itemType, quantity); //Adding Free items to cart.

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

    public void removeItemsFromList(ItemType itemType, int quantity)throws Exception {

        int count;

        List<Item> tempCart = cart.stream().filter(item -> itemType.equals(item.getItemType()) && (!item.isFree())).collect(Collectors.toList());
        count = tempCart.size();

        if (quantity < count) {

            cart.removeAll(tempCart.stream().limit(quantity).collect(Collectors.toList()));

                tempCart.clear();
                tempCart = cart.stream().filter(item -> itemType.equals(item.getItemType()) && (item.isFree())).collect(Collectors.toList());
                int offerQuantity = tempCart.size();

            if (offerQuantity > 0) {

                int finaloffer = (count - quantity) / 2;
                int finalquantity = offerQuantity - finaloffer;

                cart.removeAll(tempCart.stream().limit(finalquantity).collect(Collectors.toList()));
            }
        }
        else
            throw new Exception(String.format("The list has less number of Items"));
    }
}
