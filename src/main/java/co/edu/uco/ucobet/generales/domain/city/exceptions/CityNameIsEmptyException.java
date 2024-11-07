package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;

public class CityNameIsEmptyException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameIsEmptyException create(MessageCatalogService messageCatalogService) {
        var userMessage = messageCatalogService.getMessageOrDefault("CityNameIsEmptyException");
        return new CityNameIsEmptyException(userMessage);
    }

}
