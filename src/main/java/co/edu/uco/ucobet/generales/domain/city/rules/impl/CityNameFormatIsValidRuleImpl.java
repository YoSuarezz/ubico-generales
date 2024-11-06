package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {
	private static final Pattern VALID_CITY_NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
	private final MessageCatalogService messageCatalogService;

    public CityNameFormatIsValidRuleImpl(final MessageCatalogService messageCatalogService) {
        this.messageCatalogService = messageCatalogService;
    }


    @Override
	public void validate(String data) {
		if (!VALID_CITY_NAME_PATTERN.matcher(data).matches()) {
			throw CityNameFormatIsNotValidException.create(messageCatalogService);
		}
	}
}
