package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
        BankAccountService.openAccount("0123456789");

        ArgumentCaptor<BankAccount> argumentRecord = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDAO).saveAccount(argumentRecord.capture());
        assertEquals(0, argumentRecord.getValue().getBalance(), 0.01);
    }
    @Test
    public void testGetInfoBankAccount(){
        BankAccount account = BankAccountService.openAccount("0123456789");
        BankAccountService.getInfoAccount("0123456789");

        ArgumentCaptor<BankAccount> argumentRecord = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDAO).getAccount("0123456789");
        when(bankAccountDAO.getAccount("0123456789")).thenReturn(account);

        assertEquals(0.0, account.getBalance(), 0.01);
    }
    @Test
    public void testTransactionDeposit(){
        BankAccount account = BankAccountService.openAccount("0123456789");
        when(BankAccountService.getInfoAccount("0123456789")).thenReturn(account);
        BankAccountService.deposit("0123456789", 100.0, "deposit");

        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDAO, times(2)).saveAccount(argumentCaptor.capture());

        List<BankAccount> listAccount = argumentCaptor.getAllValues();
        assertEquals("deposit", listAccount.get(1).getDes());
        //assertEquals(100, listAccount.get(1).getBalance(),0.01);
    }
}
