package com.works.beerstore.service;

import java.util.Optional;

import com.works.beerstore.modelo.Beer;
import com.works.beerstore.repository.Beers;
import com.works.beerstore.service.exception.BeerAlreadyExistException;
import com.works.beerstore.service.exception.BeerNotFoundException;

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
        verifyIfBeerExists(beer);
        return beers.save(beer);
    }

    private void verifyIfBeerExists(final Beer beer) {
        Optional<Beer> beerByNameAndType = beers.findByNameAndType
                (beer.getName(), beer.getType());

        if (beerByNameAndType.isPresent() && (beer.isNew() ||
                isUpdatingToADifferentBeer(beer, beerByNameAndType))) {
            throw new BeerAlreadyExistException();
        }
    }
    
    private boolean isUpdatingToADifferentBeer(Beer beer,
                                               Optional<Beer> beerByNameAndType) {
        return beer.alreadyExist() && !beerByNameAndType.get()
                .equals(beer);
    }

    public void deleteById(final Long id) {
        final Optional<Beer> beer = beers.findById(id);
        if (!beer.isPresent()) {
            throw new BeerNotFoundException();
        }

        beers.delete(beer.get());
	}

}