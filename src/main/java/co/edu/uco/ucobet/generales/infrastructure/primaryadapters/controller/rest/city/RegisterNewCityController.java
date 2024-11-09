package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RetrieveCities;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.response.CityResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/general/api/v1/cities")
@CrossOrigin(origins = {"https://localhost:8080", "https://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final RetrieveCities retrieveCities;
    private final MessageCatalogService messageCatalogService;
    private final CityRepository cityRepository;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor, RetrieveCities retrieveCities, MessageCatalogService messageCatalogService, CityRepository cityRepository) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.retrieveCities = retrieveCities;
        this.messageCatalogService = messageCatalogService;
        this.cityRepository = cityRepository;
    }

    @PostMapping("/crearciudad")
    public ResponseEntity<CityResponse> registrar(@RequestBody RegisterNewCityDTO registerNewCityDTO) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var cityResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(registerNewCityDTO);
            var mensajeUsuario = "La ciudad se ha registrado correctamente";
            cityResponse.getMensajes().add(mensajeUsuario);
        } catch (final UcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            cityResponse.getMensajes().add(excepcion.getUserMessage());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "La ciudad no se ha podido registrar";
            cityResponse.getMensajes().add(mensajeUsuario);
            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(cityResponse, httpStatusCode);
    }

    @GetMapping
    public ResponseEntity<List<RegisterNewCityDTO>> obtenerCiudades() {
        var cities = cityRepository.findAll()
                .stream()
                .map(CityEntityMapper.INSTANCE::toDomain)
                .map(cityDomain -> new RegisterNewCityDTO(cityDomain.getState().getId(), cityDomain.getName()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}