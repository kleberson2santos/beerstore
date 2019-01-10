package com.works.beerstore.repository;

import java.util.Optional;

import com.works.beerstore.modelo.Beer;
import com.works.beerstore.modelo.BeerType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Beers
 */
public interface Beers extends JpaRepository<Beer, Long>{

    Optional<Beer> findByNameAndType(String name, BeerType type);
    
}