package org.kin.sendkin.lib.utills;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import kin.sdk.Environment;
import kin.sdk.KinAccount;
import kin.sdk.KinClient;

public class KinAccountUtils {

    private static final String NETWORK_URL_EXTRA = "networkUrlExtra";
    private static final String NETWORK_PASSPHRASE_EXTRA = "networkPassphraseExtra";
    private static final String APP_ID_EXTRA = "appIdExtra";
    private static final String STORE_KEY_EXTRA = "storeKeyExtra";
    private static final String PUBLIC_ADDRESS_EXTRA = "publicAddressExtra";

    //TODO
    private static final int  ADDRESS_LEN = 27;

    public static boolean isValidPublicAddress(String address){
        //TODO find pattern
        return address != null && !address.isEmpty() && address.length() == ADDRESS_LEN;
    }

    public static Intent saveKinAccountData(@NonNull Intent intent, @NonNull KinClient kinClient, @NonNull String publicAddress){
        intent.putExtra(NETWORK_URL_EXTRA, kinClient.getEnvironment().getNetworkUrl());
        intent.putExtra(NETWORK_PASSPHRASE_EXTRA, kinClient.getEnvironment().getNetworkPassphrase());
        intent.putExtra(APP_ID_EXTRA, kinClient.getAppId());
        intent.putExtra(STORE_KEY_EXTRA, kinClient.getStoreKey());
        intent.putExtra(PUBLIC_ADDRESS_EXTRA, publicAddress);
        return intent;
    }

    @Nullable
    public static KinAccount loadAccountClientData(@NonNull Context context, @NonNull Intent intent){
        final String networkUrl = intent.getStringExtra(NETWORK_URL_EXTRA);
        final String networkPassphrase = intent.getStringExtra(NETWORK_PASSPHRASE_EXTRA);
        final String appId = intent.getStringExtra(APP_ID_EXTRA);
        final String storeKey = intent.getStringExtra(STORE_KEY_EXTRA);
        final String publicAddress = intent.getStringExtra(PUBLIC_ADDRESS_EXTRA);
        KinClient kinClient = new KinClient(context, new Environment(networkUrl, networkPassphrase), appId, storeKey);
        return getKinAccount(kinClient, publicAddress);
    }


    @Nullable
    private static KinAccount getKinAccount(@NonNull KinClient kinClient, @NonNull String publicAddress) {
        KinAccount kinAccount = null;
        if (!TextUtils.isEmpty(publicAddress)) {
            int numOfAccounts = kinClient.getAccountCount();
            for (int i = 0; i < numOfAccounts; i++) {
                KinAccount account = kinClient.getAccount(i);
                if (account != null && account.getPublicAddress().equals(publicAddress)) {
                    kinAccount = account;
                    break;
                }
            }
        }
        return kinAccount;
    }
}
