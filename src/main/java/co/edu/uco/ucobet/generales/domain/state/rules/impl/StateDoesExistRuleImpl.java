package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;

public class StateDoesExistRuleImpl implements StateDoesExistRule {
	
	private final StateRepository stateRepository;

    public StateDoesExistRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

	@Override
	public void validate(UUID data) {
		if(stateRepository.existsById(data)) {
			throw CityStateDoesNotExistsException.create();
		}
		
	}

}
