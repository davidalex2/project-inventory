package com.algoriant.product.exceptionHandler;

import com.algoriant.product.model.ImsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalImsException {

    @ExceptionHandler(ImsException.class)
    public ResponseEntity<String> handlingTheInternalServerException(ImsException ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

}
