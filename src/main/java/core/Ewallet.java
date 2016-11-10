package core;


public class Ewallet {

    private double money;

    public Ewallet(){}

//    public Ewallet(double money){
//        this.money = money;
//    }

    public double getMoney() { //This will get the money in our wallet
        return money;
    }

    private void setMoney(double money) { //This will set the money in our wallet.
        this.money = money;
    }

    public void topUpMoney(double addmoney) {  //This will add money in to our E-wallet

        setMoney(money+addmoney);

    }
    public void deductMoney(double dedmoney){  //This will subtract money from out E-wallet

        if(dedmoney >=100){
            dedmoney = dedmoney -((5*dedmoney)/100);
        }
        setMoney(money-dedmoney);
    }
    public boolean checkCustomerCanPay(double cost){
        return money<cost ? false : true ;
    }

}
