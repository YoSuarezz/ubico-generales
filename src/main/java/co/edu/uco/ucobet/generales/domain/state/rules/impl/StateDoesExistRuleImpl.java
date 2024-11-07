package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateDoesExistRuleImpl implements StateDoesExistRule {

	private final StateRepository stateRepository;
	private final MessageCatalogService messageCatalogService;


	public StateDoesExistRuleImpl(final StateRepository stateRepository,final MessageCatalogService messageCatalogService) {
		this.stateRepository = stateRepository;
        this.messageCatalogService = messageCatalogService;
    }

	@Override
	public void validate(UUID data) {
		if(!stateRepository.existsById(data)) {
			throw StateDoesNotExistException.create(messageCatalogService);
		}
	}
}