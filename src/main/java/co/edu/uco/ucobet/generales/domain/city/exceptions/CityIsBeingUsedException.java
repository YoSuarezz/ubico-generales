package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIsBeingUsedException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityIsBeingUsedException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityIsBeingUsedException create() {
        var userMessage = "La ciudad esta siendo utilizada en otra parte del sistema";
        return new CityIsBeingUsedException(userMessage);
    }

}
