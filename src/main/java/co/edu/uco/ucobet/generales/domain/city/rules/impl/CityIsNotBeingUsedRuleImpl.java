package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import org.springframework.stereotype.Service;

@Service
public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{

	private CityRepository cityRepository;
	private final MessageCatalogService messageCatalogService;

	public CityIsNotBeingUsedRuleImpl(final CityRepository cityRepository,final MessageCatalogService messageCatalogService) {
		this.cityRepository = cityRepository;
        this.messageCatalogService = messageCatalogService;
    }



	@Override
	public void validate(CityDomain data) {
		if(cityRepository.isCityBeingUsed(data.getId())) {
			throw CityIsBeingUsedException.create(messageCatalogService);
		}
	}

}
