package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghtIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameLengthIsValidRuleImpl implements CityNameLenghtIsValidRule {

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 100;
	private final MessageCatalogService messageCatalogService;

    public CityNameLengthIsValidRuleImpl(final MessageCatalogService messageCatalogService) {
        this.messageCatalogService = messageCatalogService;
    }

    @Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw CityNameLenghtIsNotValidException.create(messageCatalogService);
		}
	}
}
