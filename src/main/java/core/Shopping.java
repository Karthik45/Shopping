package core;


public class Shopping {

    Item item;
    int quantity;
    ShoppingCart shoppingCart;
    Ewallet ewallet;

    public Shopping(){
        shoppingCart = new ShoppingCart();
        ewallet = new Ewallet();
        ewallet.topUpMoney(200.0);
    }

    public void addItemToCart(Item item, int quantity){ //This method will add the item into cart.

        shoppingCart.addItemToList(item,quantity);

    }

    public void payMoney()throws Exception{  // By using this method we will pay the bill by ewallet money.

        double total,balance;
        total = shoppingCart.calculateTotalPrice();
        balance = ewallet.getMoney();
        if(balance >= total){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
            ewallet.deductMoney(total);
            System.out.println("Payment Successful" );
            shoppingCart.cart.clear();
        }
        else {   //Else we again it shows less amount in wallet again we have options like addMoneyToWallet() or restAmountPayThroughCash()
            throw new Exception(String.format("Ur wallet have less balance"));
        }

    }

}
