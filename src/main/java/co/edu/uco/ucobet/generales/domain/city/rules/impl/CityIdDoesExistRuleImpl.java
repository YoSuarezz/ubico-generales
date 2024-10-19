package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;

import java.util.UUID;


public final class CityIdDoesExistRuleImpl implements CityIdDoesExistsRule {

    private CityRepository cityRepository;

    public CityIdDoesExistRuleImpl(final CityRepository cityRepository) {
        this.cityRepository= cityRepository;
    }

    @Override
    public void validate(final UUID data) {
        if(!cityRepository.existsById(data)){
            throw CityIdDoesNotExistsException.create();
        }
    }
}
