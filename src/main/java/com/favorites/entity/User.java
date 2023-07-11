package com.favorites.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue
	private Long userId;
	@Column
	private String userName;
	@Column
	private String userEmail;
	@Column
	private String userPassword;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Favorites> favorites;
	

	public List<Favorites> getFavorites() {
		return favorites;
	}


	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}


	public User(Long userId, String userName, String userEmail, String userPassword, List<Favorites> favorites) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.favorites = favorites;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}

