package core;


public class Ewallet {

    double money;

    public Ewallet(){
        this.money = 200.0;
    }

    public Ewallet(double money){
        this.money = money;
    }

    public double getMoney() { //This will get the money in our wallet
        return money;
    }

    public void setMoney(double money) { //This will set the money in our wallet.
        this.money = money;
    }

    public void topUpMoney(double money) {  //This will add money in to our E-wallet
        double balance = getMoney();
        balance = balance+money;
        setMoney(balance);
    }
    public void deductMoney(double money){  //This will subtract money from out E-wallet
        double balance = getMoney();
        balance = balance-money;
        setMoney(balance);
    }

}
