package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;
import org.springframework.stereotype.Service;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule {
	private final MessageCatalog messageCatalog;

	public StateIdIsNotNullRuleImpl(final MessageCatalog messageCatalog) {
		this.messageCatalog = messageCatalog;
	}


	@Override
	public void validate(UUID data) {
		if (ObjectHelper.isNull(data)) {
			throw StateIdIsNullException.create(messageCatalog);
		}

	}

}