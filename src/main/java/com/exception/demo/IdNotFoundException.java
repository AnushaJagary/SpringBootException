package com.exception.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class IdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
}
