package com.example.sfgrestdocsexample.web.mappers;

import com.example.sfgrestdocsexample.domain.Beer;
import com.example.sfgrestdocsexample.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/03/22
 */
@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto dto);
}
