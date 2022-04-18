package com.example.midan.model.Exceptions;

public class OfferNotFoundException extends RuntimeException{
    public OfferNotFoundException(Long id){
        super(String.format("Offer with id %d was not found", id));
    }
}
