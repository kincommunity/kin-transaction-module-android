package org.kin.sendkin.lib;

import android.content.Context;
import android.support.annotation.NonNull;

import org.kin.sendkin.lib.exceptions.ModuleError;
import org.kin.sendkin.lib.model.AddressBookImpl;
import org.kin.sendkin.lib.view.SendKinActivity;

import kin.sdk.KinAccount;
import kin.sdk.KinClient;

public class SendKinManager {

    private KinAccount kinAccount;
    private KinClient kinClient;
    private static volatile SendKinManager instance;

    public static void init(@NonNull Context context, @NonNull KinClient kinClient, @NonNull KinAccount kinAccount) {
        if (instance == null) {
            synchronized (SendKinManager.class) {
                if (instance == null) {
                    instance = new SendKinManager(context, kinClient, kinAccount);
                }
            }
        }
    }


    public static SendKinManager getInstance() {
        return instance;
    }

    private SendKinManager(Context context, KinClient kinClient, KinAccount kinAccount) {
        this.kinAccount = kinAccount;
        this.kinClient = kinClient;
        AddressBookImpl.init(context);
    }

    public void launchSendActivity(Context context) throws ModuleError {
        if(instance == null){
            throw new ModuleError("module is not init");
        }
        context.startActivity(SendKinActivity.getInstance(context, kinClient, kinAccount.getPublicAddress()));
    }
}
