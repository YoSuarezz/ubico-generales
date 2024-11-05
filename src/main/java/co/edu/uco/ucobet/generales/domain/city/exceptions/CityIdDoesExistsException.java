package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;

public class CityIdDoesExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static CityIdDoesExistsException create(MessageCatalogService messageCatalogService) {
        var userMessage = messageCatalogService.getMessageOrDefault("CityIdDoesExistsException");
        return new CityIdDoesExistsException(userMessage);
    }
}