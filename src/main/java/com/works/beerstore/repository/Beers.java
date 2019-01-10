package com.works.beerstore.repository;

import com.works.beerstore.modelo.Beer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Beers
 */
public interface Beers extends JpaRepository<Beer, Long>{

    
}