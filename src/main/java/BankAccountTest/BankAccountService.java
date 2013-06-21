package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/19/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountService {
    protected static BankAccountDAO bankAccountDAO;
    public static BankAccountDAO setData(BankAccountDAO bankAccountDAO) {
        return BankAccountService.bankAccountDAO = bankAccountDAO;  //To change body of created methods use File | Settings | File Templates.
    }

    public static BankAccount openAccount(String accNumber) {
        BankAccount bankAccount = new BankAccount(accNumber);
        bankAccountDAO.saveAccount(bankAccount);
        return bankAccount;  //To change body of created methods use File | Settings | File Templates.
    }
    public static BankAccount getInfoAccount(String accNumber){
        return bankAccountDAO.getAccount(accNumber);
    }

    public static BankAccount deposit(String accNumber, double amount, String deposit) {
        BankAccount account = getInfoAccount(accNumber);
        account.setBalance(account.getBalance()+ amount);
        account.setDes(deposit);
        bankAccountDAO.saveAccount(account);
        return account;  //To change body of created methods use File | Settings | File Templates.
    }
}
