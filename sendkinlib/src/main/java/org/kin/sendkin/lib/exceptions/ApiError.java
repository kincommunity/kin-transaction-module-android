package org.kin.sendkin.lib.exceptions;

public class ApiError extends Exception {
    public ApiError(String error){
        super(error);
    }
}
