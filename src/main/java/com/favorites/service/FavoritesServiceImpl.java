package com.favorites.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favorites.Dto.FavoritesDto;
import com.favorites.Dto.FavoritesDto2;
import com.favorites.entity.Favorites;
import com.favorites.entity.Product;
import com.favorites.entity.User;
import com.favorites.repository.FavoritesRepository;
import com.favorites.repository.ProductRepository;
import com.favorites.repository.UserRepository;

@Service
public class FavoritesServiceImpl implements FavoritesService{
	
	@Autowired
	private FavoritesRepository favoritesRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public String addFavorites(FavoritesDto favoritesDto) {
		Long productId=favoritesDto.getProductId();
    	Long userId=favoritesDto.getUserId();
    	Favorites app=new Favorites();
    	
//    	for product
    	Product product;
    	product = productRepo.findById(productId).get();
    	app.setProduct(product);
    	
    	
//    	for user
    	User user;
    	user = userRepo.findById(userId).get();
    	app.setUser(user);
    				

    	favoritesRepo.save(app);
    	
    	return "Favorites Created";
    }

	@Override
	public FavoritesDto2 getFavorites(Long favoritesId) {
		Favorites a =  favoritesRepo.findById(favoritesId).get();
		FavoritesDto2 ap = new FavoritesDto2();
        ap.setFavoritesId(a.getFavoritesId());
        ap.setProductId(a.getProduct().getProductId());
        ap.setUserId(a.getUser().getUserId());
        return ap;
    }

	@Override
	public List<FavoritesDto2> getAllFavorites() {
    	List <Favorites> favoritesList = favoritesRepo.findAll();
    	
    	List<FavoritesDto2> favoritesDtoList = new ArrayList<>();
    	
    	for(Favorites ap : favoritesList) {
    		FavoritesDto2 app2 = new FavoritesDto2();
    		app2.setFavoritesId(ap.getFavoritesId());
    		app2.setProductId(ap.getProduct().getProductId());
    		app2.setUserId(ap.getUser().getUserId());
    		
    		favoritesDtoList.add(app2);
    		
    	}
    	return favoritesDtoList;
    }

	@Override
	public String deleteFavorites(Long favoritesId) {
		// TODO Auto-generated method stub
		favoritesRepo.deleteById(favoritesId);
		return "Favorites Deleted Successfully";
	}

}
