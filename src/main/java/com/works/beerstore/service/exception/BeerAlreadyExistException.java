package com.works.beerstore.service.exception;

import org.springframework.http.HttpStatus;

/**
 * BeerAlreadyExistException
 */
public class BeerAlreadyExistException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public BeerAlreadyExistException() {
        super("beers-5", HttpStatus.BAD_REQUEST);
    }
}