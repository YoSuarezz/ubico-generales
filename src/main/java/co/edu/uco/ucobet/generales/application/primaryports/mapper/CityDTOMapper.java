package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public interface CityDTOMapper {

    CityDTOMapper INSTANCE = Mappers.getMapper(CityDTOMapper.class);

    CityDTO toDto(CityDomain domain);

    CityDomain toDomain(CityDTO dto);

    List<CityDTO> toDTOCollection(List<CityDomain> domainCollection);

    List<CityDomain> toDomainCollection(List<CityDTO> dtoCollection);

}
