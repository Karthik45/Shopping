package core;


import builder.ItemsBuilder;
import resources.ItemType;
import java.util.stream.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> cart;

    private double cartPrice;
    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }


    public ShoppingCart() {
        this.cart = new ArrayList<Item>(); //This list consist of the selected item and offeritems
    }

    public List<Item> getCart() {
        return cart;
    }


    public double calculateTotalPrice() {//This calculate the total price of the selected item.

        double total = 0.0;

        for (Item item : cart) {
            if (!item.isFree()) {
                total = total + item.getPrice();
            }
        }
        return total;
    }

    public void addItemToList(ItemType itemType, int quantity, double price) {

        for (int i = quantity; i > 0; i--) {
            Item item = new ItemsBuilder().withItems(itemType).withPrice(price).build();
            cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
        }

    }

    public void shoppingDone() {
        cart.clear();
    }

    public void removeItemsFromList(ItemType itemType, int quantity)throws Exception {

        int count;

        List<Item> tempCart = cart.stream().filter(item -> itemType.equals(item.getItemType()) && (!item.isFree())).collect(Collectors.toList());
        count = tempCart.size();

        if (quantity < count) {
            cart.removeAll(tempCart.stream().limit(quantity).collect(Collectors.toList()));
        }
        else
            throw new Exception(String.format("The list has less number of Items"));
    }
}
