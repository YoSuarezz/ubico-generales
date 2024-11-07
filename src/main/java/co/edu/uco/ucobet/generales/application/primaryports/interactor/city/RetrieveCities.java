package co.edu.uco.ucobet.generales.application.primaryports.interactor.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import java.util.List;

public interface RetrieveCities {
    List<RegisterNewCityDTO> getAllCities();
}
