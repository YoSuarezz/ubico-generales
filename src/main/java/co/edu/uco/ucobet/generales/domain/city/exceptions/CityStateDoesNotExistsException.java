package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityStateDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityStateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityStateDoesNotExistsException create() {
        var userMessage = "El estado asociado a la ciudad no existe.";
        return new CityStateDoesNotExistsException(userMessage);
    }

}
