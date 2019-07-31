package org.kin.sendkin.lib.model;


import android.support.annotation.NonNull;

import org.kin.sendkin.lib.exceptions.PublicAddressNotValid;

import java.util.List;

public interface AddressBook {

    void addContact(@NonNull String name, @NonNull String address) throws PublicAddressNotValid;
    List<KinContact> getContacts();
    void addContact(KinContact contact);
    void removeContact(String id);
    void updateContact(KinContact contact);
}
