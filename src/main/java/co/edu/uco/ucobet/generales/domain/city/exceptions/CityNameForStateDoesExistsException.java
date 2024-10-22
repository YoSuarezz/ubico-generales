package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameForStateDoesExistsException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameForStateDoesExistsException create() {
        var userMessage = "El nombre de la ciudad para este departamento ya existe";
        return new CityNameForStateDoesExistsException(userMessage);
    }

}
