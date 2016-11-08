package core;


public class Shopping {

    Item item;
    int quantity;
    ShoppingCart shoppingCart;
    Ewallet ewallet;

    public Shopping(){
        ewallet = new Ewallet();
        shoppingCart = new ShoppingCart();
    }

    public void addItemToCart(Item item, int quantity){ //This method will add the item into cart.
        while(quantity > 0)
        {
            shoppingCart.cart.add(item); //In this we will insert item into list like if we have quantity as 2. it will insert item into cart two times.
            quantity--;
        }

    }

    public void payMoney(){  // By using this method we will pay the bill by ewallet money.

        double total,balance;
        total = shoppingCart.calculateTotalPrice();
        balance = ewallet.getMoney();
        if(balance >= total){  //if we have sufficent money to pay our bills in E-wallet then we can pay.
            deductMoney(total);
        }
        else {   //Else we again it shows less amount in wallet again we have options like addMoneyToWallet() or restAmountPayThroughCash()
            System.out.println("Less amount in the E-wallet!!! You only have:" + balance );
            
        }

    }

    public void topUpMoney(double money) {  //This will add money in to our E-wallet
        double balance = ewallet.getMoney();
        balance = balance+money;
        ewallet.setMoney(balance);
    }

    public void deductMoney(double money){  //This will subtract money from out E-wallet
        double balance = ewallet.getMoney();
        balance = balance-money;
        ewallet.setMoney(balance);

    }
}
