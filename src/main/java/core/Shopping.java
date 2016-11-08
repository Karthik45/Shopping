package core;


public class Shopping {

    Items items;
    int quantity;
    ShoppingCart shoppingCart;
    Ewallet ewallet;

    public void addItemToCart(Items item,int quantity){ //This method will add the item into cart.
        while(quantity > 0)
        {
            shoppingCart.cart.add(item); //In this we will insert items into list like if we have quantity as 2. it will insert item into cart two times.
            quantity--;
        }

    }

    public void payMoney(){  // By using this method we will pay the bill by ewallet money.

        double total,balance;
        total = shoppingCart.calculateTotalPrice();
        balance = ewallet.getMoney();
        if(balance >= total){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
            ewallet.setMoney(balance-total);
        }
        else {   //Else we again it shows less amount in wallet again we have options like addMoneyToWallet() or restAmountPayThroughCash()
            System.out.println("Less amount in the E-wallet!!! You only have:" + balance );
        }
    }
}
