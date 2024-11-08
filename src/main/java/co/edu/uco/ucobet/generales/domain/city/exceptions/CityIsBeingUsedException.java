package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogInterface;

public class CityIsBeingUsedException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityIsBeingUsedException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityIsBeingUsedException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityIdIsBeingUsedException");
        return new CityIsBeingUsedException(userMessage);
    }
}
