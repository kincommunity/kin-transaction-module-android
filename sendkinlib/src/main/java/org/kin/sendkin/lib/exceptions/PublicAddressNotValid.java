package org.kin.sendkin.lib.exceptions;

public class PublicAddressNotValid extends Exception {
    public PublicAddressNotValid(String address){
        super("address " + address + " is not valid blockchain address");
    }
}
