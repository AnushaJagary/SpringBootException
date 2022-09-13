package com.exception.demo.controlleradvicer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exception.demo.IdNotFoundException;
import com.exception.demo.model.Product;

@ControllerAdvice
public class ProductIdNotFoundException  {
	 
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<Object> exception(IdNotFoundException exception){
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
		
	}

}
