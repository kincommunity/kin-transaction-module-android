package org.kin.sendkin.lib.exceptions;

public class BalanceError extends Exception {
    public BalanceError(String error){
        //TODO format parse error
        super("Can not get balance " + error);
    }
}
