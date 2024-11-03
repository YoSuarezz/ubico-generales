package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.CityDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

    private RegisterNewCity registerNewCity;

    public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity) {
        super();
        this.registerNewCity = registerNewCity;
    }

    @Override
    public void execute(final RegisterNewCityDTO data) {
        //Data mapper -> DTO -> Domain

        final var cityDomain= CityDTOMapper.INSTANCE.toDomain(data);
        registerNewCity.execute(cityDomain);
    }
}