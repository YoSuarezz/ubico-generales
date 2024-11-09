package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.RetrieveStates;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/general/api/v1/states")
@CrossOrigin(origins = {"https://localhost:8080", "https://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class StateController {

    private final StateRepository stateRepository;
    private final RetrieveStates retrieveStates;

    public StateController(StateRepository stateRepository, RetrieveStates retrieveStates) {
        this.stateRepository = stateRepository;
        this.retrieveStates = retrieveStates;
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