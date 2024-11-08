package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogInterface;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdIsNullException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import org.springframework.stereotype.Service;

@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule{

	private final MessageCatalogInterface messageCatalog;

    public CityIdIsNotNullRuleImpl(final MessageCatalogInterface messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsNullException.create(messageCatalog);
		}
	}
}