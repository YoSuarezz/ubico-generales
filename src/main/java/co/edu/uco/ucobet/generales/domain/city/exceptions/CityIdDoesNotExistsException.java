package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesNotExistsException extends RuleUcobetException {

    private static final long serialVersionUTD = 1L;

    public CityIdDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdDoesNotExistsException create(){
        var userMessage = "No existe la ciudad con el id indicado.";
        return new CityIdDoesNotExistsException(userMessage);
    }
}
