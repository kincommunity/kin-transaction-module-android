package org.kin.sendkin.lib.view;

import android.support.annotation.NonNull;

import org.kin.sendkin.core.base.BaseView;

public interface SendKinView extends BaseView {
    void updateBalance(int balance);
    void openPopupDialogPublicAddress(@NonNull String publicAddress);
}