package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;

public class CityNameForStateDoesExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameForStateDoesExistsException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityNameForStateDoesExistsException");
        return new CityNameForStateDoesExistsException(userMessage);
    }

}
