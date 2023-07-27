package com.prueba_spring_boot.prueba_backend.infrastructure.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends UserException{

    private static final long serialVersionUID = -5501898474346060617L;

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

    public int getCode() {
        return super.getCode();
    }
}

