package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import org.springframework.stereotype.Service;

@Service
public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{

	private CityRepository cityRepository;
	private final MessageCatalogInterface messageCatalog;

	public CityIsNotBeingUsedRuleImpl(final CityRepository cityRepository, MessageCatalogInterface messageCatalog) {
		this.cityRepository = cityRepository;
        this.messageCatalog = messageCatalog;
    }



	@Override
	public void validate(CityDomain data) {
		if(cityRepository.isCityBeingUsed(data.getId())) {
			throw CityIsBeingUsedException.create(messageCatalog);
		}
	}

}
