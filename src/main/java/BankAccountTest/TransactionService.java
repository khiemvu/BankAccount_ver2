package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/23/13
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionService {
    private static TransactionDAO transactionDAO;
    public static void initData(TransactionDAO transactionDAO) {
        TransactionService.transactionDAO = transactionDAO;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void deposit(String accNumber, long time, double amount, String deposit) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
