package com.favorites.service;

import java.util.List;

import com.favorites.Dto.FavoritesDto;
import com.favorites.Dto.FavoritesDto2;

public interface FavoritesService { 
	
	public String addFavorites(FavoritesDto favoritesDto);
	public FavoritesDto2 getFavorites(Long favoritesId);
	public List<FavoritesDto2> getAllFavorites();
	public String deleteFavorites(Long favoritesId);
	


}
