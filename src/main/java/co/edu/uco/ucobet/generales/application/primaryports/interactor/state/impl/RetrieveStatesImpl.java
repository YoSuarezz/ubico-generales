package co.edu.uco.ucobet.generales.application.primaryports.interactor.state.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.RetrieveStates;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveStatesImpl implements RetrieveStates {

    private final StateRepository stateRepository;

    public RetrieveStatesImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


    @Override
    public List<StateDTO> getAllStates() {
        return stateRepository.findAll()
                .stream()
                .map(StateEntityMapper.INSTANCE::toDomain)
                .map(stateDomain -> new StateDTO(stateDomain.getId(), stateDomain.getName(), new CountryDTO(stateDomain.getCountry().getId(), stateDomain.getCountry().getName())))
                .collect(Collectors.toList());
    }
}
