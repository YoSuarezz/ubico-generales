package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;
import org.springframework.stereotype.Service;

@Service
public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {

	private final CityRepository cityRepository;
	private final MessageCatalogInterface messageCatalog;

	public CityIdDoesExistsRuleImpl(final CityRepository cityRepository, MessageCatalogInterface messageCatalog) {
		this.cityRepository = cityRepository;
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(final UUID data) {
		if (!cityRepository.existsById(data)) {
			throw CityIdDoesExistsException.create(messageCatalog);
		}
	}
}
