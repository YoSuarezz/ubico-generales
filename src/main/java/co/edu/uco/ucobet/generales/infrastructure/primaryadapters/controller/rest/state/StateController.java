package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.rest.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.RetrieveStates;

import java.util.List;

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
    public ResponseEntity<List<StateDTO>> obtenerStates(HttpServletRequest request) {
        if (!isRequestFromPort8080(request)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        var states = retrieveStates.getAllStates();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    private boolean isRequestFromPort8080(HttpServletRequest request) {
        return "8080".equals(request.getHeader("X-Forwarded-Port"));
    }
}