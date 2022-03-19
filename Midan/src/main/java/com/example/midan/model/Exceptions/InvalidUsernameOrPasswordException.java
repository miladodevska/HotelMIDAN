package com.example.midan.model.Exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{
    public InvalidUsernameOrPasswordException(){
        super("Invalid email or password exception!");
    }

}
