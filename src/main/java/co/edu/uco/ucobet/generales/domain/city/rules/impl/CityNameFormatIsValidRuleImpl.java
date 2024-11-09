package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {
	private static final Pattern VALID_CITY_NAME_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
	private final MessageCatalog messageCatalog;

    public CityNameFormatIsValidRuleImpl(final MessageCatalog messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(String data) {
		if (!VALID_CITY_NAME_PATTERN.matcher(data).matches()) {
			throw CityNameFormatIsNotValidException.create(messageCatalog);
		}
	}
}
