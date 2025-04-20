package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends RuntimeException {
    private final HttpStatus status;

    public BurgerException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    // Testin beklediği getter:
    public HttpStatus getHttpStatus() {
        return status;
    }

    // Alternatif olarak hâlihazırdaki getStatus()'u da koruyabilirsiniz:
    public HttpStatus getStatus() {
        return status;
    }
}
