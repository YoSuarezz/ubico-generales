package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public final class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistsRule{
	
	private CityRepository cityRepository;

	public CityIdDoesNotExistsRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(UUID data) {
		if(cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsException.create();
		}
	}
}
