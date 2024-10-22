package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;

public class StateIdIsNotDefaultValueRuleImpl implements StateIdIsNotDefaultValueRule {

	@Override
	public void validate(UUID data) {
		if (UUIDHelper.isDefault(data)) {
			throw StateIdIsDefaultValueException.create();
		}

	}

}
