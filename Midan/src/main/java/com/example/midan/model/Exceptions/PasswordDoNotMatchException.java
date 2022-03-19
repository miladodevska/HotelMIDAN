package com.example.midan.model.Exceptions;

public class PasswordDoNotMatchException  extends RuntimeException{
    public PasswordDoNotMatchException()
    {
        super("Password do not match exception");
    }
}
