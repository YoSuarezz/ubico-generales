package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;

public class CityNameIsNullException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameIsNullException create(MessageCatalogService messageCatalogService) {
        var userMessage = messageCatalogService.getMessageOrDefault("CityIdDoesExistsException");;
        return new CityNameIsNullException(userMessage);
    }

}
