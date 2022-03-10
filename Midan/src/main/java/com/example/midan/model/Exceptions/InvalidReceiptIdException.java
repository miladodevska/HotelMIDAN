package com.example.midan.model.Exceptions;

public class InvalidReceiptIdException extends RuntimeException{
    public InvalidReceiptIdException(){
        super("Invalid Receipt ID!");
    }

}
