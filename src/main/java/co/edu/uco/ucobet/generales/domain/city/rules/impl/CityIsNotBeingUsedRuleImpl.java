package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;

public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{

	private CityRepository cityRepository;

	public CityIsNotBeingUsedRuleImpl(final CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public void validate(CityDomain data) {
		if(cityRepository.isCityBeingUsed(data.getId())) {
			throw CityIsBeingUsedException.create();
		}
	}

}
