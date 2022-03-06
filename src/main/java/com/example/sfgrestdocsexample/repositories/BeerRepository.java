package com.example.sfgrestdocsexample.repositories;

import com.example.sfgrestdocsexample.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/03/22
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
