package com.favorites.Dto;


public class FavoritesDto2 { 
	
	private Long favoritesId;
	
	private Long userId;
	
	private Long productId;

	public FavoritesDto2(Long favoritesId, Long userId, Long productId) {
		super();
		this.favoritesId = favoritesId;
		this.userId = userId;
		this.productId = productId;
	}

	public FavoritesDto2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(Long favoritesId) {
		this.favoritesId = favoritesId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	

}
