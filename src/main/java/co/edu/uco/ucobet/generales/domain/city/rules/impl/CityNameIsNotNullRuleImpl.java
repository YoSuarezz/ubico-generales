package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {


	private final MessageCatalogService messageCatalogService;

    public CityNameIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
        this.messageCatalogService = messageCatalogService;
    }

    @Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw CityNameIsNullException.create(messageCatalogService);
		}

	}

}
