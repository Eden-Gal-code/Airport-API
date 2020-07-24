package com.eden.checkin.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler {


    @ExceptionHandler(LuggageWeightPerOneException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDetails handleLuggageWeightPerOne(LuggageWeightPerOneException ex, WebRequest request) {
        ErrorDetails err=new ErrorDetails();
        err.setCode(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setValue(request.getParameter("flightID"));
        return err;
    }
    @ExceptionHandler(LuggageTotalWeightException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDetails handleLuggageTotalWeight(LuggageTotalWeightException ex, WebRequest request) {
        ErrorDetails err=new ErrorDetails();
        err.setCode(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setValue(request.getParameter("flightID"));
        return err;
    }
    @ExceptionHandler(CanGetSeatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDetails handleGetSeat(CanGetSeatException ex, WebRequest request) {
        ErrorDetails err=new ErrorDetails();
        err.setCode(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setValue(request.getParameter("flightID"));
        return err;
    }
    @ExceptionHandler(LuggageNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ErrorDetails handleLuggageNumber(LuggageNumberException ex, WebRequest request) {
        ErrorDetails err=new ErrorDetails();
        err.setCode(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setValue(request.getParameter("flightID"));
        return err;
    }

}