package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/23/13
 * Time: 8:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private Long time;
    private String accNumber;
    private String des;
    private double amount;
    Transaction(String accNumber, Long time, double amount, String des){
        this.accNumber = accNumber;
        this.time = time;
        this.amount = amount;
        this.des = des;
    }
    public long getTime() {
        return this.time;  //To change body of created methods use File | Settings | File Templates.
    }
}
