package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameFormatIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {
	private static final Pattern VALID_CITY_NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
	private final MessageCatalogInterface messageCatalog;

    public CityNameFormatIsValidRuleImpl(final MessageCatalogInterface messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(String data) {
		if (!VALID_CITY_NAME_PATTERN.matcher(data).matches()) {
			throw CityNameFormatIsNotValidException.create(messageCatalog);
		}
	}
}
