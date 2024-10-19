package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;

import java.util.UUID;

public class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

    @Override
    public void validate(UUID data) {
        if(ObjectHelper.isNull(data)){
            // Throw Exception
        }
    }
}
