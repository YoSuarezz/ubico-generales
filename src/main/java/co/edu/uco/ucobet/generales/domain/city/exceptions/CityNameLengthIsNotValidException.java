package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;

public class CityNameLengthIsNotValidException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameLengthIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameLengthIsNotValidException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityNameLengthIsNotValidException");
        return new CityNameLengthIsNotValidException(userMessage);
    }
}
