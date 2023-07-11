package com.favorites.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.favorites.Dto.FavoritesDto;
import com.favorites.Dto.FavoritesDto2;
import com.favorites.service.FavoritesService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/favorites")
public class FavoritesController { 
	
	@Autowired
	private FavoritesService favoritesServ;
	
	@PostMapping("/addFavorites")
	public ResponseEntity<?> addFavorites(@RequestBody FavoritesDto favoritesDto) {
		return new ResponseEntity<String> (favoritesServ.addFavorites(favoritesDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getFavorites/{favoritesId}")
	@HystrixCommand(fallbackMethod = "fallback_getFavorites", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getFavorites(@PathVariable Long favoritesId){
		return new ResponseEntity<FavoritesDto2> (favoritesServ.getFavorites(favoritesId), HttpStatus.OK);
	}
	
	@GetMapping("/getFavorites")
	@HystrixCommand(fallbackMethod = "fallback_getAllFavorites", commandProperties = {
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public ResponseEntity<?> getAllFavoritess() {
		
		return new ResponseEntity<List<FavoritesDto2>> (favoritesServ.getAllFavorites(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFavorites/{favoritesId}")
	public ResponseEntity<?> deleteFavorites(@PathVariable Long favoritesId) {
		return new ResponseEntity<String> (favoritesServ.deleteFavorites(favoritesId), HttpStatus.OK);
	}
	
	private ResponseEntity<?> fallback_getFavorites(Long favoritesId) {
        // Fallback response when getFavorites fails
        return new ResponseEntity<String>("Unable to fetch favorites. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<?> fallback_getAllFavorites() {
        // Fallback response when getAllFavorites fails
        return new ResponseEntity<String>("Unable to fetch all favorites. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
