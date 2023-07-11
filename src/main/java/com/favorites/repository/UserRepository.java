package com.favorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.favorites.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
