package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RetrieveCities;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.secondaryadapters.messages.MessageCatalog;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = "https://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final RetrieveCities retrieveCities;
    private final MessageCatalog messageCatalog;
    private final CityRepository cityRepository;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor, RetrieveCities retrieveCities, MessageCatalog messageCatalog, CityRepository cityRepository) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.retrieveCities = retrieveCities;
        this.messageCatalog = messageCatalog;
        this.cityRepository = cityRepository;
    }

    @PostMapping("/crearciudad")
    public ResponseEntity<CityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO, HttpServletRequest request) {
        if (!isRequestFromPort8080(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(registerNewCityDTO);
            var mensajeUsuario = messageCatalog.getMessageOrDefault("CityRegisteredSuccess");
            cityResponse.getMensajes().add(mensajeUsuario);
        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = messageCatalog.getMessageOrDefault("CityRegistrationFailed");
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }
        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }

    @GetMapping

    public ResponseEntity<List<RegisterNewCityDTO>> obtenerCiudades(HttpServletRequest request) {
        if (!isRequestFromPort8080(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        var cities = retrieveCities.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    private boolean isRequestFromPort8080(HttpServletRequest request) {
        return "8080".equals(request.getHeader("X-Forwarded-Port"));
    }
}