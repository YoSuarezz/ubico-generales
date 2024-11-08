package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogInterface;

public class CityIdDoesExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdDoesExistsException create(MessageCatalogInterface messageCatalog) {
        var userMessage = messageCatalog.getMessageOrDefault("CityIdDoesExistsException");
        return new CityIdDoesExistsException(userMessage);
    }
}