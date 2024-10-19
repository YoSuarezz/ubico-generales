package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityIntercator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public class RegisterNewCityIntercatorImpl implements RegisterNewCityIntercator {

    private RegisterNewCity registerNewCity;

    public RegisterNewCityIntercatorImpl(RegisterNewCity registerNewCity) {
        this.registerNewCity = registerNewCity;
    }

    @Override
    public void execute(RegisterNewCityDTO data) {
        //DataMapper -> Dto to Domain
        final var cityDomain = new CityDomain(null,null,null);

        registerNewCity.execute(cityDomain);
    }
}

