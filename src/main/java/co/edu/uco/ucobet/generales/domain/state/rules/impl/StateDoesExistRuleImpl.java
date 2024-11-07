package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateDoesExistRuleImpl implements StateDoesExistRule {

	private final StateRepository stateRepository;

	public StateDoesExistRuleImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public void validate(UUID data) {
		if(!stateRepository.existsById(data)) {
			throw StateDoesNotExistException.create();
		}
	}
}