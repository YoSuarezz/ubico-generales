package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;

public class CityNameIsEmptyException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameIsEmptyException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityNameIsEmptyException");
        return new CityNameIsEmptyException(userMessage);
    }

}
