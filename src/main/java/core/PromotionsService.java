package core;

import builder.ItemsBuilder;
import resources.ItemType;

import java.util.List;
import java.util.stream.Collectors;

public class PromotionsService {

    public List<Item> applyPromotions(ShoppingCart shoppingCart) {

        List<Item> cart = shoppingCart.getCart();

        applyBuy2Get1FreeMilkPromotion(cart);

        apply5PercentOffOnSumGreaterThan99(shoppingCart);

        return cart;
    }

    private void applyBuy2Get1FreeMilkPromotion(List<Item> cart) {

           int noOfItems = (int) cart.stream().filter(item -> item.getItemType().equals(ItemType.Milk) && (!item.isFree())).count();

           int freeItems = noOfItems / 2;

           int noOfFreeItemsPresent = (int) cart.stream().filter(item -> item.getItemType().equals(ItemType.Milk) && (item.isFree())).count();

           if (freeItems > noOfFreeItemsPresent) {

               int quantity = freeItems - noOfFreeItemsPresent;

               for (int i = quantity; i > 0; i--) {

                   Item freeItem = new ItemsBuilder().withItems(ItemType.Milk).withOffer(true).build();
                   cart.add(freeItem);
               }
           }

           else if (noOfFreeItemsPresent > freeItems){

               int quantity = noOfFreeItemsPresent - freeItems;

               List<Item> tempCart = cart.stream().filter(item -> item.getItemType().equals(ItemType.Milk) && (item.isFree())).collect(Collectors.toList());

               cart.removeAll(tempCart.stream().limit(quantity).collect(Collectors.toList()));
           }


    }


    private void apply5PercentOffOnSumGreaterThan99(ShoppingCart shoppingCart) {

        double total = 0.0, totalAfterDiscount=0.0;

        total = shoppingCart.calculateTotalPrice();

        totalAfterDiscount = total > 99.0 ? (total - (total*5)/100) : total;

        shoppingCart.setCartPrice(totalAfterDiscount);
    }

}



