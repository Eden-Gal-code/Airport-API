package com.eden.checkin.error;

public class CanGetSeatException extends Exception {
    public CanGetSeatException (){
        super("Cannot get a seat.");
    }
}
