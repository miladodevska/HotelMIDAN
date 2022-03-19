package com.example.midan.model.Exceptions;

public class InvalidGuestCredentialException extends RuntimeException {
    public InvalidGuestCredentialException()
    {
        super("Invalid guest credentials exception");
    }
}
