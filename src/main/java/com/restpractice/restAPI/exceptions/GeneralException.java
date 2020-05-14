package com.restpractice.restAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "")
public class GeneralException extends RuntimeException {

    public GeneralException(String message) {
        super(message);
    }
}