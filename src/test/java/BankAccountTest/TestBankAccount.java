package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/19/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    @Mock
    protected BankAccountDAO bankAccountDAO;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        BankAccountService.setData(bankAccountDAO);
    }
    @Test
    public void testOpenBankAccount(){
        BankAccount account = new BankAccount("0123456789");

        ArgumentCaptor<BankAccount> argumentRecord = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDAO).saveAccount(argumentRecord.capture());
        assertEquals(0.0, argumentRecord.getValue().getBalance());
    }
}
