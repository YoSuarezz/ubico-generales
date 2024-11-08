package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;

public class CityIdDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUTD = 1L;

    public CityIdDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdDoesNotExistsException create(MessageCatalogInterface messageCatalog){
        var userMessage = messageCatalog.getMessageOrDefault("CityIdDoesNotExistsException");
        return new CityIdDoesNotExistsException(userMessage);
    }
}
