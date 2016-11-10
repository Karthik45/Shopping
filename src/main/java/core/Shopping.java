package core;


public class Shopping {

    Item item;
    int quantity;
    ShoppingCart shoppingCart;
    public Ewallet ewallet;

    public Shopping(double money){
        shoppingCart = new ShoppingCart();
        ewallet = new Ewallet();
        ewallet.topUpMoney(money);
    }

    public void addItemToCart(Item item, int quantity){ //This method will add the item into cart.
        if(item.getItemType().equals("Milk")){
        shoppingCart.addItemToList(item,quantity);
        shoppingCart.offerItems(item,quantity/2);}
        else
            shoppingCart.addItemToList(item,quantity);
    }
    private double calculatePrice(){
      return shoppingCart.calculateTotalPrice();
    }

    public void payMoney()throws Exception{  // By using this method we will pay the bill by ewallet money.

        double total;
        total = calculatePrice();

        if(ewallet.checkCustomerCanPay(total)){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
            ewallet.deductMoney(total);
            System.out.println("Payment Successful" );
            shoppingCart.shoppingDone();
        }
        else {   //Else we again it shows less amount in wallet again we have options like addMoneyToWallet() or restAmountPayThroughCash()
            throw new Exception(String.format("Ur wallet have less balance"));
        }

    }

}
