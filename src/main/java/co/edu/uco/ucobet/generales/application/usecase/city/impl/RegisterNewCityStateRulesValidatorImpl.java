package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public final class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {

    private StateDoesExistRule stateDoesExistRule;
    private StateIdIsNotNullRule stateIdIsNotNullRule;
    private StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule;

    public RegisterNewCityStateRulesValidatorImpl(final StateDoesExistRule stateDoesExistRule,
                                                  final StateIdIsNotNullRule stateIdIsNotNullRule,
                                                  final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule) {
        this.stateDoesExistRule = stateDoesExistRule;
        this.stateIdIsNotNullRule = stateIdIsNotNullRule;
        this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
    }

    @Override
    public void validate(final UUID data) {
        validateState(data);
    }

    private void validateState(final UUID data){
        stateDoesExistRule.validate(data);
        stateIdIsNotNullRule.validate(data);
        stateIdIsNotDefaultValueRule.validate(data);
    }
}