package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.messages.MessageCatalogInterface;

public class CityNameLenghtIsNotValidException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameLenghtIsNotValidException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityNameLenghtIsNotValidException");
        return new CityNameLenghtIsNotValidException(userMessage);
    }
}
