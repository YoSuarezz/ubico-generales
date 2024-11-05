package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;
import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;
import org.springframework.stereotype.Service;

@Service
public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {

	private final CityRepository cityRepository;
	private final MessageCatalogService messageCatalogService;

	public CityIdDoesExistsRuleImpl(final CityRepository cityRepository, MessageCatalogService messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void validate(final UUID data) {
		if (!cityRepository.existsById(data)) {
			throw CityIdDoesExistsException.create(messageCatalogService);
		}
	}
}
