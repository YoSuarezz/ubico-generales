package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityStateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class CityStateDoesNotExistsRuleImpl implements CityStateDoesNotExistsRule {

    private final StateRepository stateRepository;
    private final MessageCatalog messageCatalog;


    public CityStateDoesNotExistsRuleImpl(final StateRepository stateRepository,final MessageCatalog messageCatalog) {
        this.stateRepository = stateRepository;
        this.messageCatalog = messageCatalog;
    }



    @Override
    public void validate(StateDomain stateDomain) {
        boolean exists = stateRepository.existsById(stateDomain.getId());
        if (!exists) {
            throw CityStateDoesNotExistsException.create(messageCatalog);
        }
    }
}