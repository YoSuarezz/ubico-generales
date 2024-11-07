package co.edu.uco.ucobet.generales.domain.state.rules.impl;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateIdIsNotDefaultValueRuleImpl implements StateIdIsNotDefaultValueRule {

	private final MessageCatalogService messageCatalogService;

    public StateIdIsNotDefaultValueRuleImpl(final MessageCatalogService messageCatalogService) {
        this.messageCatalogService = messageCatalogService;
    }

    @Override
	public void validate(UUID data) {
		if (UUIDHelper.isDefault(data)){
			throw StateIdIsDefaultValueException.create(messageCatalogService);
		}
	}
}