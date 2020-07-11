package com.eden.checkin.error;

public class LuggageWeightPerOneException extends Exception {
    public LuggageWeightPerOneException(){
        super("A single suitcase weight is not allowed");
    }
}
