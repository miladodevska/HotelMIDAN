package com.example.midan.model.Exceptions;

public class InvalidRoomIdException extends RuntimeException{
    public InvalidRoomIdException(){
        super("Invalid Room ID!");
    }
}
