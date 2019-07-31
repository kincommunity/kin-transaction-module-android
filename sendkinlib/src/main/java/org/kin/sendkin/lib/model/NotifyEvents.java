package org.kin.sendkin.lib.model;

public interface NotifyEvents {
    void onTriggerClicked();
    void onSend(String receiverAddress, int amount);


}
