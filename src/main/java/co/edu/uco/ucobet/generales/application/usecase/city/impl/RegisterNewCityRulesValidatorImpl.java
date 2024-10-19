package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {

    private RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator;
    private RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator;
    private RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator;

    public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator registerNewCityIdRulesValidator,
                                             final RegisterNewCityStateRulesValidator registerNewCityStateRulesValidator,
                                             final RegisterNewCityNameRulesValidator registerNewCityNameRulesValidator) {
        this.registerNewCityIdRulesValidator = registerNewCityIdRulesValidator;
        this.registerNewCityStateRulesValidator = registerNewCityStateRulesValidator;
        this.registerNewCityNameRulesValidator = registerNewCityNameRulesValidator;
    }

    @Override
    public void validate(final CityDomain data) {
        registerNewCityIdRulesValidator.validate(data);
        registerNewCityStateRulesValidator.validate(data.getState().getId());
        registerNewCityNameRulesValidator.validate(data);
    }
}
