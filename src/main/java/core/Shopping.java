package core;


import resources.ItemType;

public class Shopping {

    public ShoppingCart shoppingCart;
    public Ewallet ewallet;

    public Shopping(double money){
        shoppingCart = new ShoppingCart();
        ewallet = new Ewallet();
        ewallet.topUpMoney(money);
    }

    public void addItemToCart(ItemType itemType, int quantity, double price) { //This method will add the item into cart.
        if(quantity > 0) {
            shoppingCart.addItemToList(itemType, quantity, price);
        }
        else
            System.out.println("quantity should be more than zero");
    }

    public void removeItemFromCart(ItemType itemType,int quantity) {
        if(quantity >0){
        shoppingCart.removeItemFromList(itemType,quantity);
        }
        else
            System.out.println("quantity for removal should be more than zero");
    }

    private double calculatePrice(){
      return shoppingCart.calculateTotalPrice();
    }

    public void payMoney()throws Exception{  // By using this method we will pay the bill by ewallet money.

        double total;
        total = calculatePrice();

        if(ewallet.checkCustomerCanPay(total)){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
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
