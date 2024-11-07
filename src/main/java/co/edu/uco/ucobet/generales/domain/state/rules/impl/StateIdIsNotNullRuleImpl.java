package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import org.springframework.stereotype.Service;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {
	private final MessageCatalogService messageCatalogService;

    public StateIdIsNotNullRuleImpl(final MessageCatalogService messageCatalogService) {
        this.messageCatalogService = messageCatalogService;
    }


    @Override
	public void validate(UUID data) {
		if (ObjectHelper.isNull(data)) {
			throw StateIdIsNullException.create(messageCatalogService);
		}

	}

}
