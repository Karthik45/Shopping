package core;


import resources.ItemType;


public class Shopping {

    public ShoppingCart shoppingCart;
    public Ewallet ewallet;
    public PromotionsService promotionsService;


    public Shopping(double money){
        shoppingCart = new ShoppingCart();
        ewallet = new Ewallet();
        ewallet.topUpMoney(money);
    }

    public void addItemToCart(ItemType itemType, int quantity, double price)throws Exception { //This method will add the item into cart.
        if(quantity > 0) {
            shoppingCart.addItemToList(itemType, quantity, price);
            promotionsService = new PromotionsService();
            promotionsService.applyPromotions(shoppingCart);
        }
        else
            throw new Exception(String.format("Item quantity should be more than zero"));
    }

    public void removeItemFromCart(ItemType itemType,int quantity)throws Exception {
        if (quantity > 0) {
                shoppingCart.removeItemsFromList(itemType, quantity);
                promotionsService.applyPromotions(shoppingCart);
        }
           else
               throw new Exception(String.format("Removal Items should be more than zero"));

    }

    public int getCartSize(){
        int size = (shoppingCart.getCart()).size();
        return size;
    }

    public void payMoney()throws Exception{// By using this method we will pay the bill by ewallet money.

        double total;

        total = shoppingCart.getCartPrice();
        if(ewallet.hasEnoughMoney(total)){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
            System.out.println(total);
            ewallet.deductMoney(total);
            System.out.println("Payment Successful" );

            shoppingCart.shoppingDone();
        }
        else {   //Else we again it shows less amount in wallet again we have options like addMoneyToWallet() or restAmountPayThroughCash()
            throw new Exception(String.format("Ur wallet have less balance"));
        }

    }

}
