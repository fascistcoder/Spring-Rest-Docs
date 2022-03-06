package com.example.sfgrestdocsexample.web.controllers;

import com.example.sfgrestdocsexample.repositories.BeerRepository;
import com.example.sfgrestdocsexample.web.mappers.BeerMapper;
import com.example.sfgrestdocsexample.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/03/22
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    @GetMapping("/{beerId}")
    @ResponseStatus(HttpStatus.OK)
    public BeerDto getBeerById(@PathVariable("beerId")UUID beerId){
        return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).get());
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
        beerRepository.save(beerMapper.BeerDtoToBeer(beerDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto){
        beerRepository.findById(beerId).ifPresent(beer -> {
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle().name());
            beer.setPrice(beerDto.getPrice());
            beer.setUpc(beerDto.getUpc());

            beerRepository.save(beer);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
