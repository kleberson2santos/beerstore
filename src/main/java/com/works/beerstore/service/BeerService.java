package com.works.beerstore.service;

import java.util.Optional;

import com.works.beerstore.modelo.Beer;
import com.works.beerstore.repository.Beers;
import com.works.beerstore.service.exception.BeerAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BeerService
 */
@Service
public class BeerService {

    private Beers beers;

    public BeerService(@Autowired Beers beers) {
        this.beers = beers;
    }

    public Beer save(final Beer beer) {
        Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());
        if (beerByNameAndType.isPresent()) {
            throw new BeerAlreadyExistException();
        }

        return beers.save(beer);
    }

}