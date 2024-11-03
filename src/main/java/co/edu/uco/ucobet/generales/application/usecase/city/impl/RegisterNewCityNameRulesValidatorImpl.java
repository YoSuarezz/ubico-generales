package co.edu.uco.ucobet.generales.application.usecase.city.impl;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

    private final CityNameLenghtIsValidRule cityNameLengthIsValidRule;
    private final CityNameFormatIsValidRule cityNameFormatIsValidRule;
    private final CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
    private final CityNameIsNotNullRule cityNameIsNotNullRule;
    private final CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule;

    @Autowired
    public RegisterNewCityNameRulesValidatorImpl(
            CityNameLenghtIsValidRule cityNameLengthIsValidRule,
            CityNameFormatIsValidRule cityNameFormatIsValidRule,
            CityNameIsNotEmptyRule cityNameIsNotEmptyRule,
            CityNameIsNotNullRule cityNameIsNotNullRule,
            CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule) {
        this.cityNameLengthIsValidRule = cityNameLengthIsValidRule;
        this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
        this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
        this.cityNameIsNotNullRule = cityNameIsNotNullRule;
        this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {
        validateName(data);
    }

    private void validateName(final CityDomain data) {
        cityNameIsNotEmptyRule.validate(data.getName());
        cityNameIsNotNullRule.validate(data.getName());
        cityNameLengthIsValidRule.validate(data.getName());
        cityNameFormatIsValidRule.validate(data.getName());
        cityNameForStateDoesNotExistsRule.validate(data);
    }
}