package core;


public class Ewallet {

    private double money,discountPercent;

    public Ewallet(){
         discountPercent = 5.0;
    }

    public double getMoney() { //This will get the money in our wallet
        return money;
    }

    public void topUpMoney(double addmoney) {  //This will add money in to our E-wallet

        money = money+addmoney;

    }

    public void deductMoney(double dedmoney){  //This will subtract money from out E-wallet

        money = money-(dedmoney - getDiscount(dedmoney));
    }

    public boolean hasEnoughMoney(double cost){
        return money<cost ? false : true ;
    }

    private double getDiscount(double money) {

        if (money >= 100) {
            return (money * discountPercent) / 100;
        }
        else
            return 0.0;

    }

}
