package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;

    public RegisterNewCityImpl(final CityRepository cityRepository,
                               final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
    }

    @Override
    public void execute(CityDomain domain) {
        // 1. Validar las reglas
        registerNewCityRulesValidator.validate(domain);

        // 2. Mapper de CityDomain a CityEntity
        final var cityEntity = CityEntity.create()
                .setId(domain.getId())
                .setName(domain.getName())
                .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

        // 3. Guardar CityEntity
        cityRepository.save(cityEntity);

        //Notificar al administrador sobre la creacion de la nueva ciudad
        //TODO: ¿Cómo? Notification Building Block

        //Tenga en cuenta que:
        // 1. El correo del administrador está en un lugar parametrizado (Parameters Building Block)
        // 2. El mensaje de notificación está en un lugar parametrizado (Parameters Building Block)
        // 3. El asunto del correo está en un lugar parametrizado (Parameters Building Block)
    }
}

