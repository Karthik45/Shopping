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

}
