package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {
	private CityRepository cityRepository;
	private final MessageCatalog messageCatalog;


	public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository, MessageCatalog messageCatalog) {
		this.cityRepository = cityRepository;
        this.messageCatalog = messageCatalog;
    }

	@Override
	public void validate(CityDomain data) {
		var cityEntity = CityEntity.create().setName(data.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));
		var resultado = cityRepository.findByFilter(cityEntity);
		if (!resultado.isEmpty()) {
			throw CityNameForStateDoesExistsException.create(messageCatalog);
		}
	}
}