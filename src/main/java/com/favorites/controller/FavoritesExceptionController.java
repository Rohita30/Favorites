package com.favorites.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.favorites.exception.FavoritesNotFoundException;

@ControllerAdvice
public class FavoritesExceptionController { 
	
	@ExceptionHandler(value = FavoritesNotFoundException.class)
	   public ResponseEntity<Object> exception(FavoritesNotFoundException exception) {
		   
	      return new ResponseEntity<>("Favorite is not found", HttpStatus.NOT_FOUND);
	      
	   }


}
