package org.kin.sendkin.lib.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.kin.sendkin.lib.R;
import org.kin.sendkin.lib.utills.KinAccountUtils;
import org.kin.sendkin.lib.presenter.SendKinPresenterImpl;

import kin.sdk.KinAccount;
import kin.sdk.KinClient;

public class SendKinActivity extends AppCompatActivity implements SendKinView {
    private SendKinPresenterImpl presenter;

    public static Intent getInstance(@NonNull Context context, @NonNull KinClient kinClient, @NonNull String publiAddress){
        Intent intent = new Intent(context, SendKinActivity.class);
        return KinAccountUtils.saveKinAccountData(intent, kinClient, publiAddress);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final KinAccount kinAccount = KinAccountUtils.loadAccountClientData(this, getIntent());
        if(kinAccount != null){
            presenter = new SendKinPresenterImpl(kinAccount);
            presenter.onAttach(this);
        }
        setContentView(R.layout.send_kin_activity);
    }

    @Override
    public void updateBalance(int balance){
        ((TextView) findViewById(R.id.balance)).setText("balance:" + balance);
    }

    @Override
    public void openPopupDialogPublicAddress(@NonNull String publicAddress) {
        ((TextView) findViewById(R.id.balance)).setText("address  " + publicAddress);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }
}
