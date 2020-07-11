package com.eden.checkin.error;

public class LuggageTotalWeightException extends Exception {

    public LuggageTotalWeightException(){
        super ("Luggage total weifht not allowed");
    }
}
