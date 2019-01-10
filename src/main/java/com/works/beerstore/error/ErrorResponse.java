package com.works.beerstore.error;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import org.springframework.http.HttpStatus;

import static lombok.AccessLevel.PRIVATE;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * ErrorResponse
 */
@JsonAutoDetect(fieldVisibility = ANY)
@RequiredArgsConstructor(access =  PRIVATE)
public class ErrorResponse {

    private final int statusCode;
    private final List<ApiError> errors; 

    static ErrorResponse of(HttpStatus status, List<ApiError> errors) {
        return new ErrorResponse(status.value(), errors);
    }

    static ErrorResponse of(HttpStatus status, ApiError error) {
        return of(status, Collections.singletonList(error));
    }

    @JsonAutoDetect(fieldVisibility = ANY)
    @RequiredArgsConstructor
    static class ApiError {
        private final String code;
        private final String message;
    }
}