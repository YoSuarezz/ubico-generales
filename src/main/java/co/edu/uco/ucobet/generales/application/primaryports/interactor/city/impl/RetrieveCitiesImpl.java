package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RetrieveCities;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveCitiesImpl implements RetrieveCities {

    private final CityRepository cityRepository;

    public RetrieveCitiesImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<RegisterNewCityDTO> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(CityEntityMapper.INSTANCE::toDomain)
                .map(cityDomain -> new RegisterNewCityDTO(cityDomain.getState().getId(), cityDomain.getName()))
                .collect(Collectors.toList());
    }
}
