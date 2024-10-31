package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/general/api/v1/states")

@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
public class StateController {
    private final StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public ResponseEntity<List<StateDTO>> obtenerStates() {
        var states = stateRepository.findAll()
                .stream()
                .map(StateEntityMapper.INSTANCE::toDomain)
                .map(stateDomain -> new StateDTO(stateDomain.getId(), stateDomain.getName(), new CountryDTO(stateDomain.getCountry().getId(), stateDomain.getCountry().getName())))
                .collect(Collectors.toList());

        return new ResponseEntity<>(states, HttpStatus.OK);
    }
}