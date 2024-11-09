package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;

public class CityStateDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityStateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityStateDoesNotExistsException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityStateDoesNotExistsException");
        return new CityStateDoesNotExistsException(userMessage);
    }

}
