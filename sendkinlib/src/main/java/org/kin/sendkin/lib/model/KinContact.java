package org.kin.sendkin.lib.model;

import android.support.annotation.NonNull;

import org.kin.sendkin.lib.exceptions.PublicAddressNotValid;
import org.kin.sendkin.lib.utills.KinAccountUtils;

import java.util.UUID;


public class KinContact {
    private String id;
    private String publicAddress;
    private String name;

    public KinContact(@NonNull String name, @NonNull String publicAddress) throws PublicAddressNotValid {
            this.name = name;
            updateAddress(publicAddress);
            id = UUID.randomUUID().toString();
    }

    public void updateName(@NonNull String newName){
        this.name = newName;
    }

    public  void updateAddress(@NonNull String newPublicAddress) throws PublicAddressNotValid {
        if(!KinAccountUtils.isValidPublicAddress(newPublicAddress)){
            throw new PublicAddressNotValid(newPublicAddress);
        }
        this.publicAddress = newPublicAddress;
    }

    public String getNane(){ return name; }

    public String getId(){ return id; }


    public String getPublicAddress(){ return publicAddress; }

    @Override
    public String toString() {
        return "Name: " + name + " public address: " + publicAddress;
    }
}
