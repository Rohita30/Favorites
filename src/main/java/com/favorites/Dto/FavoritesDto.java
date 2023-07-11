package com.favorites.Dto;

public class FavoritesDto { 
	
	private Long userId;
	
	private Long productId;

	public FavoritesDto(Long userId, Long productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public FavoritesDto() {
		super();
		// TODO Auto-generated constructor stub
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
