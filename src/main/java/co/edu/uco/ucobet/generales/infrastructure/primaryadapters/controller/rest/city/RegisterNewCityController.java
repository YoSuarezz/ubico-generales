package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RetrieveCities;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.SanitizerHelper;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
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
    private final SanitizerHelper sanitizerHelper;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor, RetrieveCities retrieveCities, MessageCatalog messageCatalog, SanitizerHelper sanitizerHelper) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.retrieveCities = retrieveCities;
        this.messageCatalog = messageCatalog;
        this.sanitizerHelper = sanitizerHelper;
    }

    @PostMapping("/crearciudad")
    public ResponseEntity<CityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO, HttpServletRequest request) {
        if (!isRequestFromPort8080(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new CityResponse();

        registerNewCityDTO.setCityName(sanitizerHelper.sanitizeInput(registerNewCityDTO.getCity()));

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