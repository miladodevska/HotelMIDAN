package com.example.midan.model.Exceptions;

public class InvalidEmployeeIdException extends RuntimeException{
    public InvalidEmployeeIdException(){
        super("Invalid employee ID!");
    }
}
