package com.bankapp.portal.exception;

import com.bankapp.portal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class BankingApplicationRestExceptionHandler {


    @ExceptionHandler(InvalidInputParameterException.class)
    public ResponseEntity<?> invalidInputParameterException(InvalidInputParameterException invalidInputParameterException) {
        return new ResponseEntity<>(new ErrorResponseDto(invalidInputParameterException.getMessage(),
                HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundException(EntityNotFoundException entityNotFoundException) {
        return new ResponseEntity<>(new ErrorResponseDto(entityNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

}
