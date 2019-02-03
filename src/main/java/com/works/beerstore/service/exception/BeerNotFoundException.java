package com.works.beerstore.service.exception;

import org.springframework.http.HttpStatus;

/**
 * BeerNotFoundException
 */
public class BeerNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public BeerNotFoundException() {
        super("beers-6", HttpStatus.NOT_FOUND);
    }
}