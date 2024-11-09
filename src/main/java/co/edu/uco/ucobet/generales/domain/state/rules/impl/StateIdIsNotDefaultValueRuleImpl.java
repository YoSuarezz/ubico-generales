package co.edu.uco.ucobet.generales.domain.state.rules.impl;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateIdIsNotDefaultValueRuleImpl implements StateIdIsNotDefaultValueRule {

	private final MessageCatalog messageCatalog;

	public StateIdIsNotDefaultValueRuleImpl(final MessageCatalog messageCatalog) {
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(UUID data) {
		if (UUIDHelper.isDefault(data)){
			throw StateIdIsDefaultValueException.create(messageCatalog);
		}
	}
}