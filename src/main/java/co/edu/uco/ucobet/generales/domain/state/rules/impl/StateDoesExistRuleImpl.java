package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateDoesExistRuleImpl implements StateDoesExistRule {

	private final StateRepository stateRepository;
	private final MessageCatalog messageCatalog;


	public StateDoesExistRuleImpl(final StateRepository stateRepository,final MessageCatalog messageCatalog) {
		this.stateRepository = stateRepository;
		this.messageCatalog = messageCatalog;
	}

	@Override
	public void validate(UUID data) {
		if(!stateRepository.existsById(data)) {
			throw StateDoesNotExistException.create(messageCatalog);
		}
	}
}