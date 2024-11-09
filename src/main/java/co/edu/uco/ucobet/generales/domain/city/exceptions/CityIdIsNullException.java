package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;

public class CityIdIsNullException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityIdIsNullException create(MessageCatalog messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityIdIsNotNullException");
        return new CityIdIsNullException(userMessage);
    }

}
