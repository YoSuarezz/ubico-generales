package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;

public class CityIdIsNullException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityIdIsNullException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityIdIsNotNullException");
        return new CityIdIsNullException(userMessage);
    }

}
