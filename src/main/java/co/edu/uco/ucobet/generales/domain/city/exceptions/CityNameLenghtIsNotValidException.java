package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameLenghtIsNotValidException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameLenghtIsNotValidException create() {
        var userMessage = "La longitud del nombre de la ciudad no es válido.";
        return new CityNameLenghtIsNotValidException(userMessage);
    }

}
