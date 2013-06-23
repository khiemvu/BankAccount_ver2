package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void testSaveTimeWhenTransactionDeposit(){
        when(time.getTime()).thenReturn(100L);

        TransactionService.deposit("0123456789", 100L, 100, "deposit");
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO).save(argumentCaptor.capture());

        assertEquals(100L, argumentCaptor.getValue().getTime());
    }
    @Test
    public void testSaveTimeWhenTransactionWithdraw(){
        when(time.getTime()).thenReturn(100L);

        TransactionService.withdraw("0123456789", 100L, 100, "withdraw");
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO).save(argumentCaptor.capture());

        assertEquals(100L, argumentCaptor.getValue().getTime());
        assertEquals(100, argumentCaptor.getValue().getBalace(), 0.01);
    }
}
