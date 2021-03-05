package com.example.app.core.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aliaksandr Miron
 */
@ResponseStatus(NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
}
