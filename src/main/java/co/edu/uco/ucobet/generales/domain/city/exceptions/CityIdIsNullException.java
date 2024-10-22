package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdIsNullException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityIdIsNullException create() {
        var userMessage = "El Id de la ciudad no puede ser Nulo";
        return new CityIdIsNullException(userMessage);
    }

}
