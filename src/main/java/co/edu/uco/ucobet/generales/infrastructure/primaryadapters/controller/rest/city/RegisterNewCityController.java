package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RetrieveCities;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final RetrieveCities retrieveCities;
    private final MessageCatalogService messageCatalogService;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor, RetrieveCities retrieveCities, MessageCatalogService messageCatalogService) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.retrieveCities = retrieveCities;
        this.messageCatalogService = messageCatalogService;
    }

    @PostMapping("/crearciudad")
    public ResponseEntity<CityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(registerNewCityDTO);
            var mensajeUsuario = messageCatalogService.getMessageOrDefault("CityRegisteredSuccess");
            cityResponse.getMensajes().add(mensajeUsuario);
        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageCatalogService.getMessageOrDefault("CityRegistrationFailed");
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }
        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }

    @GetMapping
    public ResponseEntity<List<RegisterNewCityDTO>> obtenerCiudades() {
        try {
            var cities = retrieveCities.getAllCities();
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (final Exception excepcion) {
            excepcion.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}