package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;

import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;

public final class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

    private CityIdDoesNotExistsRule cityIdDoesNotExistsRule;

    public RegisterNewCityIdRulesValidatorImpl(final CityIdDoesNotExistsRule cityIdDoesNotExistsRule) {
        this.cityIdDoesNotExistsRule = cityIdDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {
        try {
            data.generateId();
            cityIdDoesNotExistsRule.validate(data.getId());
        } catch (CityIdDoesExistsException exception) {
            validate(data);
        }
    }

}
