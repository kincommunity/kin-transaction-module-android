package org.kin.sendkin.lib.model;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kin.sendkin.lib.exceptions.AccountError;
import org.kin.sendkin.lib.exceptions.BalanceError;
import org.kin.sendkin.lib.presenter.SendKinPresenter;
import org.mockito.Mockito;

import java.math.BigDecimal;

import kin.sdk.Balance;
import kin.sdk.KinAccount;
import kin.sdk.exception.OperationFailedException;

import static org.junit.Assert.*;

public class KinManagerImplTest {

    private static final String TAG = KinManagerImplTest.class.getSimpleName();
    private SendKinPresenter sendKinPresenter;
    private KinAccount kinAccount = Mockito.mock(KinAccount.class);
    private KinManager kinManager;
    private String address = "abcd";
    private BigDecimal balance  = new BigDecimal(25);
    private String balanceStr  = "25.0";



    @Before
    public void setUp() throws OperationFailedException {
        Mockito.when(kinAccount.getBalanceSync()).thenReturn(new Balance() {
            @Override
            public BigDecimal value() {
                return balance;
            }

            @Override
            public String value(int precision) {
                return balanceStr;
            }
        });
        Mockito.when(kinAccount.getPublicAddress()).thenReturn(address);
        kinManager = new KinManagerImpl(kinAccount);
    }

    @After
    public void reset(){
    }

    @Test
    public void getPublicAddress() {
        try {
            assertEquals(kinManager.getPublicAddress(),address);
        } catch (AccountError accountError) {
            accountError.printStackTrace();
        }
    }

    @Test
    public void getCurrentBalance() {
    }

    @Test
    public void getCurrentBalanceSync() {
        try {
            assertEquals(kinManager.getCurrentBalanceSync() ,balance.intValue());
        } catch (BalanceError balanceError) {
            balanceError.printStackTrace();
        } catch (AccountError accountError) {
            accountError.printStackTrace();
        }

    }

    @Test
    public void sendKin() {
    }

    @Test
    public void sendKin1() {
    }

    @Test
    public void sendKinSync() {
    }

    @Test
    public void sendKinSync1() {
    }

}