package org.kin.sendkin.lib.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import org.kin.sendkin.core.base.BasePresenterImpl;
import org.kin.sendkin.lib.callbacks.BalanceCallback;
import org.kin.sendkin.lib.exceptions.AccountError;
import org.kin.sendkin.lib.model.KinManager;
import org.kin.sendkin.lib.model.KinManagerImpl;
import org.kin.sendkin.lib.view.SendKinView;

import kin.sdk.KinAccount;

public class SendKinPresenterImpl extends BasePresenterImpl<SendKinView> implements  SendKinPresenter{
    private static String TAG = SendKinPresenterImpl.class.getSimpleName();
    private KinManager kinManager;

    public SendKinPresenterImpl(@NonNull KinAccount kinAccount){
        kinManager = new KinManagerImpl(kinAccount);
    }

    @Override
    public void onResume() {
        try {
            kinManager.getCurrentBalance(new BalanceCallback() {
                @Override
                public void onBalanceReceived(int balance) {
                   getView().updateBalance(balance);
                }

                @Override
                public void onBalanceError(String error) {

                }
            });
        } catch (AccountError accountError) {
            Log.e(TAG, accountError.getMessage());
        }
    }

    @Override
    public void onAttach(SendKinView view) {
        super.onAttach(view);
    }

    @Override
    public void onBackClicked() {

    }
}
