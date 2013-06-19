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
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
