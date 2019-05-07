package com.daimler.mm.flights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FlightDataValidException extends RuntimeException {

    public FlightDataValidException(String errorMessage) {
        super(errorMessage);
    }

}
