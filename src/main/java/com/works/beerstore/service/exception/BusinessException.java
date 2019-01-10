package com.works.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * BusinessException
 */
@RequiredArgsConstructor
@Getter
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    private final String code;
    private final HttpStatus status;
    
}