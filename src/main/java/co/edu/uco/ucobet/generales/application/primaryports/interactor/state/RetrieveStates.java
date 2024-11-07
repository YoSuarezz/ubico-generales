package co.edu.uco.ucobet.generales.application.primaryports.interactor.state;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;

import java.util.List;

public interface RetrieveStates {
    List<StateDTO> getAllStates();
}
