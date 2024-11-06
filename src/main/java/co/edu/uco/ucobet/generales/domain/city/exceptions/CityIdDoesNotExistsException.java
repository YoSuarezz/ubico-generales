package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;

public class CityIdDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUTD = 1L;

    public CityIdDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdDoesNotExistsException create(MessageCatalogService messageCatalogService){
        var userMessage =messageCatalogService.getMessageOrDefault("CityIdDoesNotExistsException");
        return new CityIdDoesNotExistsException(userMessage);
    }
}
