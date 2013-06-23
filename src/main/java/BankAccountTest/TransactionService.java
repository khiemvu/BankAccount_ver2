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

    public static Transaction deposit(String accNumber, long time, double amount, String deposit) {
        Transaction transaction = new Transaction(accNumber, time, amount, deposit);//To change body of created methods use File | Settings | File Templates.
        transactionDAO.save(transaction);
        return transaction;
    }

    public static Transaction withdraw(String accNumber, long time, int amount, String withdraw) {
        Transaction transaction = new Transaction(accNumber, time, amount, withdraw);
        transactionDAO.save(transaction);
        return transaction;//To change body of created methods use File | Settings | File Templates.
    }
}
