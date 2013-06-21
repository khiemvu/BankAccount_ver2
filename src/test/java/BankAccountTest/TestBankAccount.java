package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        assertEquals(0.0, account.getBalance(),0.01);
    }
    @Test
    public void testTransactionDeposit(){

        BankAccountService.deposit("0123456789", 100.0, "deposit");
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDAO).saveAccount(argumentCaptor.capture());
        assertEquals(100, argumentCaptor.getValue().getBalance(),0.01);
        assertEquals("deposit", argumentCaptor.getValue().getDes());
    }
}
