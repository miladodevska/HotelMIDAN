package com.example.midan.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartNotFound extends RuntimeException{
    public ShoppingCartNotFound(Long id)
    {
        super(String.format("Shopping cart with %d was not found",id));
    }
}

