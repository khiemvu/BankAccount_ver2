package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/23/13
 * Time: 8:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    @Mock
    private Date time;
    @Mock
    private TransactionDAO transactionDAO;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        TransactionService.initData(transactionDAO);
    }
    @Test
    public void testSaveTimeWhenDoTransaction(){
        when(time.getTime()).thenReturn(100L);
        TransactionService.doTransaction("0123456789", 100L, 100, "deposit");
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO).save(argumentCaptor.capture());
        assertEquals(100L, argumentCaptor.getValue().getTime());
        assertEquals(100, argumentCaptor.getValue().getBalace(), 0.01);

        when(time.getTime()).thenReturn(1000L);
        TransactionService.doTransaction("0123456789", 1000L, 50, "withdraw");
        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO,times(2)).save(argument.capture());
        assertEquals(1000L, argument.getValue().getTime());
        assertEquals(50, argument.getValue().getBalace(), 0.01);
    }
    @Test
    public void testGetAllTransactionOfBankAccount(){

        TransactionService.doTransaction("0123456789", 1000L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 2000L, 50, "withdraw");

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO,times(2)).save(argument.capture());
        List<Transaction> listTransaction = argument.getAllValues();
        when(transactionDAO.getAllTransaction("0123456789")).thenReturn(listTransaction);

        assertEquals(2, listTransaction.size());
        assertEquals(100, listTransaction.get(0).getBalace(), 0.01);
        assertEquals(2000L, listTransaction.get(1).getTime());
    }
    @Test
    public void testGetListTransactionInAboutTime(){

        TransactionService.doTransaction("0123456789", 1000L, 1000, "deposit");
        TransactionService.doTransaction("0123456789", 2000L, 500, "withdraw");

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO,times(2)).save(argument.capture());
        List<Transaction> listTransaction = argument.getAllValues();
        when(transactionDAO.getAllTransaction("0123456789", 50L, 3000L)).thenReturn(listTransaction);

        assertEquals(2, listTransaction.size());
        assertEquals(1000, listTransaction.get(0).getBalace(), 0.01);
        assertEquals(2000L, listTransaction.get(1).getTime());
    }
    @Test
    public void testGetNTransactionNew(){

        TransactionService.doTransaction("0123456789", 1000L, 1000, "deposit");
        TransactionService.doTransaction("0123456789", 2000L, 500, "withdraw");
        TransactionService.doTransaction("0123456789", 3000L, 300, "withdraw");

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO,times(3)).save(argument.capture());
        List<Transaction> listTransaction = argument.getAllValues();
        when(transactionDAO.getAllTransaction("0123456789", 3)).thenReturn(listTransaction);

        assertEquals(3, listTransaction.size());
        assertEquals(500, listTransaction.get(1).getBalace(), 0.01);
        assertEquals(3000L, listTransaction.get(2).getTime());
    }

}
