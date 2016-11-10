package core;


public class Ewallet {

    private double money,discountPercent;

    public Ewallet(){
         discountPercent = 5.0;
    }

//    public Ewallet(double money){
//        this.money = money;
//    }

    public double getMoney() { //This will get the money in our wallet
        return money;
    }

    public void topUpMoney(double addmoney) {  //This will add money in to our E-wallet

        money = money+addmoney;

    }
    public void deductMoney(double dedmoney){  //This will subtract money from out E-wallet

        if(dedmoney >=100){
            dedmoney = dedmoney -((discountPercent*dedmoney)/100);
        }
       money = money-dedmoney;
    }
    public boolean checkCustomerCanPay(double cost){
        return money<cost ? false : true ;
    }

}
