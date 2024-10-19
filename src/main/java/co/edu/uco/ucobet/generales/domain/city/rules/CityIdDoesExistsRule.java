package co.edu.uco.ucobet.generales.domain.city.rules;

import co.edu.uco.ucobet.generales.domain.DomainRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CityIdDoesExistsRule extends DomainRule<UUID> {

}
