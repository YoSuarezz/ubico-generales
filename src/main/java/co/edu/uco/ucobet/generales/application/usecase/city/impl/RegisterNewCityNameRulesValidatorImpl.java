package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.*;

public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {


    private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;
    private CityNameIsNotNullRule cityNameIsNotNullRule;
    private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
    private CityNameLenghtIsValidRule cityNameLenghtIsValidRule;
    private CityNameFormatIsValidRule cityNameFormatIsValidRule;

    public RegisterNewCityNameRulesValidatorImpl(final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule,
                                                 final CityNameIsNotNullRule cityNameIsNotNullRule,
                                                 final CityNameIsNotEmptyRule cityNameIsNotEmptyRule,
                                                 final CityNameLenghtIsValidRule cityNameLenghtIsValidRule,
                                                 final CityNameFormatIsValidRule cityNameFormatIsValidRule) {
        this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
        this.cityNameIsNotNullRule = cityNameIsNotNullRule;
        this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
        this.cityNameLenghtIsValidRule = cityNameLenghtIsValidRule;
        this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
    }

    @Override
    public void validate(final CityDomain data) {
        cityNameIsNotNullRule.validate(data.getName());
        cityNameForStateDoesNotExistsRule.validate(data.getName());
        cityNameIsNotEmptyRule.validate(data.getName());
        cityNameFormatIsValidRule.validate(data.getName());
        cityNameLenghtIsValidRule.validate(data.getName());
    }


}
