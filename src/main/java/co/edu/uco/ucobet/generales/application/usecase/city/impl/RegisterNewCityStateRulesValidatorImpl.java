package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

import java.util.UUID;

public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {

    private StateDoesExistRule stateDoesExistRule;
    private StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule;
    private StateIdIsNotNullRule stateIdIsNotNullRule;

    public RegisterNewCityStateRulesValidatorImpl(final StateDoesExistRule stateDoesExistRule,
                                                  final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule,
                                                  final StateIdIsNotNullRule stateIdIsNotNullRule) {
        this.stateDoesExistRule = stateDoesExistRule;
        this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
        this.stateIdIsNotNullRule = stateIdIsNotNullRule;
    }

    @Override
    public void validate(final UUID stateId) {
        stateIdIsNotNullRule.validate(stateId);
        stateIdIsNotDefaultValueRule.validate(stateId);
        stateDoesExistRule.validate(stateId);
    }
}
