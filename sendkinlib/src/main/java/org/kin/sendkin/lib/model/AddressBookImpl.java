package org.kin.sendkin.lib.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import org.kin.sendkin.lib.exceptions.PublicAddressNotValid;

import java.util.List;

public class AddressBookImpl implements AddressBook{

    private static volatile AddressBookImpl instance;
    private static final String name = "localKinAddressBook";
    private SharedPreferences sharedPreferences;

    public static void init(@NonNull Context context) {
        if (instance == null) {
            synchronized (AddressBookImpl.class) {
                if (instance == null) {
                    instance = new AddressBookImpl(context);
                }
            }
        }
    }



    private AddressBookImpl(@NonNull Context context){
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static AddressBookImpl getInstance() {
        return instance;
    }

    @Override
    public void addContact(@NonNull String name, @NonNull String address) throws PublicAddressNotValid {
        KinContact contact = new KinContact(name, address);
        sharedPreferences.edit().putString(contact.getId(), contact.toString()).apply();
    }

    @Override
    public List<KinContact> getContacts() {
        return null;//sharedPreferences.getClass(contact.getId(), contact.toString()).apply();;
    }

    @Override
    public void addContact(KinContact contact) {

    }

    @Override
    public void removeContact(String id) {

    }

    @Override
    public void updateContact(KinContact contact) {

    }

}
