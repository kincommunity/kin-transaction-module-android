package org.kin.sendkin.lib.callbacks;

public interface BalanceCallback {
    void onBalanceReceived(int balance);
    void onBalanceError(String error);
}
