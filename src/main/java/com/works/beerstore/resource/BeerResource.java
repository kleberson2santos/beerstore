package com.works.beerstore.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BeerResource
 */

 @RestController
 @RequestMapping("/beers")
public class BeerResource {

    @GetMapping
    public List<String> all() {
        return Arrays.asList("Heineken", "Colorado Indiga", "Stella Artois");
    }
    
}