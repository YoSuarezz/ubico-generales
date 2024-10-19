package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.city;


import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityIntercator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {

    /*private RegisterNewCityIntercator registerNewCityIntercator;

    public RegisterNewCityController(final RegisterNewCityIntercator registerNewCityIntercator) {
        this.registerNewCityIntercator = registerNewCityIntercator;
    }*/

    @PostMapping
    public RegisterNewCityDTO execute(@RequestBody RegisterNewCityDTO dto) {
        //registerNewCityIntercator.execute(dto);

        //Cuidado aquí: Recuerde definir el servicio siguiendo buenas practicas y asegurando que se retornen los mensajes
        // y codigos HTTP adecuados, garantizando que la estrategia REST este orientada a la buena practica

        return dto;

    }

    @GetMapping
    public RegisterNewCityDTO executedummy() {
        return new RegisterNewCityDTO("Rionegro", UUIDHelper.generate());
    }
}