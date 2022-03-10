package com.example.midan.model.Exceptions;

public class OfferNotFoundException extends RuntimeException{
    public OfferNotFoundException(){
        super("Offer not found exception!");
    }
}
