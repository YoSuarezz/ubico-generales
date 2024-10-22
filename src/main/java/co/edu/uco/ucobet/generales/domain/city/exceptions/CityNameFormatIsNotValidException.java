package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameFormatIsNotValidException extends RuleUcobetException{

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());

    }

    public static final CityNameFormatIsNotValidException create() {
        var userMessage = "El formato del nombre no es valido";
        return new CityNameFormatIsNotValidException(userMessage);
    }

}
