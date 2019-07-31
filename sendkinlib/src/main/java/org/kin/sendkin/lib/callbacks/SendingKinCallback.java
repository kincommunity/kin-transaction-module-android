package org.kin.sendkin.lib.callbacks;

public interface SendingKinCallback {
    void onSendKinCompleted(String transactionId, String receiverAddress, int amount);
    void onSendKinFailed(String error, String receiverAddress, int amount);
}
