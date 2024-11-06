package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.service.MessageCatalogService;

public class CityNameFormatIsNotValidException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameFormatIsNotValidException create(MessageCatalogService messageCatalogService) {
        var userMessage = messageCatalogService.getMessageOrDefault("CityNameFormatIsNotValidException");
        return new CityNameFormatIsNotValidException(userMessage);
    }

}
