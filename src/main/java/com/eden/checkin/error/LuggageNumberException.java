package com.eden.checkin.error;

public class LuggageNumberException extends Exception {
    public LuggageNumberException(){
        super("Luggage amount not allowed.");
    }
}
