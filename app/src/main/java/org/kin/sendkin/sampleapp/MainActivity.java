package org.kin.sendkin.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.kin.sendkin.lib.SendKinManager;

import kin.sdk.Environment;
import kin.sdk.KinAccount;
import kin.sdk.KinClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String appId = "aba";
        final KinClient kinClient = new KinClient(this, Environment.TEST, appId, "mySampleStoreKey");
        KinAccount kinAccount = kinClient.getAccount(0);
        Log.d("####", "###### address " + kinAccount.getPublicAddress());
        SendKinManager.init(MainActivity.this, kinClient, kinAccount);
    }
}
