package com.example.midan.model.Exceptions;

public class InvalidBookingIdException extends RuntimeException {
    public InvalidBookingIdException(){
        super("Invalid booking ID!");    }
}