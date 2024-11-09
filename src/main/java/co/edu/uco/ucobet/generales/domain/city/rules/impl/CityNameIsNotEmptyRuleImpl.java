package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmptyException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameIsNotEmptyRuleImpl implements CityNameIsNotEmptyRule {

	private final MessageCatalog messageCatalog;

    public CityNameIsNotEmptyRuleImpl(final MessageCatalog messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyException.create(messageCatalog);
		}

	}

}
