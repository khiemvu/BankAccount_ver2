package BankAccountTest;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.crypto.Data;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/23/13
 * Time: 8:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    @Mock
    private Data time;
    @Mock
    private TransactionDAO transactionDAO;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        TransactionService.initData(transactionDAO);
    }
}
