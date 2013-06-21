package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/19/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    String number;
    double amount;
    String des;

    public BankAccount(String accNumber) {
        this.number = accNumber;
        this.amount = 0;
    }

    public void setBalance(double amount){
        this.amount = amount;
    }
    public double getBalance() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }
    public String getNumberAccount(){
        return this.number;
    }

    public String getDes() {
        return this.des;  //To change body of created methods use File | Settings | File Templates.
    }

    public void setDes(String des) {
        this.des = des;//To change body of created methods use File | Settings | File Templates.
    }
}
