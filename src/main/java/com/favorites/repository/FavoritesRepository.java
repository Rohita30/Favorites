package com.favorites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favorites.entity.Favorites;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long>{

}
