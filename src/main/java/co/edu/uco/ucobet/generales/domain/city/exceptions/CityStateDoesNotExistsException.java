package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;

public class CityStateDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityStateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityStateDoesNotExistsException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityStateDoesNotExistsException");
        return new CityStateDoesNotExistsException(userMessage);
    }

}
