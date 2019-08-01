package org.kin.sendkin.lib.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        initViews();
    }

    private void initViews() {
        ((TextView) findViewById(R.id.address)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onShowPublicAddressClicked();
            }
        });

    }

    @Override
    public void updateBalance(int balance){
        ((TextView) findViewById(R.id.balance)).setText("balance:" + balance);
    }

    @Override
    public void showPublicAddressPopup(@NonNull final String publicAddress) {
        new AlertDialog.Builder(this)
                .setTitle("Delete entry")
                .setMessage("your address " + publicAddress)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.copy, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("public address", publicAddress);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(SendKinActivity.this, "Public address coppied", Toast.LENGTH_LONG).show();
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }
}
