package com.asteroids.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class ExceptionTranslator {

	  @ExceptionHandler(value = { DateValidation.class })
	  public ResponseEntity<Object> handleInvalidInputException(DateValidation ex) {       
	
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	
	    }
	
	
}
