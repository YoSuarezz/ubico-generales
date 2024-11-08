package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogInterface;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule {

	private final MessageCatalogInterface messageCatalog;

    public CityNameIsNotEmptyRuleImpl(final MessageCatalogInterface messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyException.create(messageCatalog);
		}

	}

}
