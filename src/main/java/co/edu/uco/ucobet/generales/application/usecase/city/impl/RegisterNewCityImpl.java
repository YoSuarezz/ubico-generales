package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


public final class RegisterNewCityImpl implements RegisterNewCity {

    private CityRepository cityRepository;
    private RegisterNewCityRulesValidator registerNewCityRulesValidator;

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
    }

    @Override
    public void execute(CityDomain Domain) {

        //Rules Validation
        registerNewCityRulesValidator.validate(Domain);

        // DataMapper -> CityDomain to CityEntity
        final var cityEntity =  CityEntity.create(null);

        // Save CityEntity
        cityRepository.save(null);

        //Notificar al administrador sobre la creacion de la nueva ciudad
        //TODO: ¿Cómo? Notification Building Block

        //Tenga en cuenta que:
        // 1. El correo del administrador está en un lugar parametrizado (Parameters Building Block)
        // 2. El mensaje de notificación está en un lugar parametrizado (Parameters Building Block)
        // 3. El asunto del correo está en un lugar parametrizado (Parameters Building Block)
    }
}

