package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesExistsException extends RuleUcobetException {

    private static final long serialVersionUTD = 1L;

    public CityIdDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdDoesExistsException create(){
        var userMessage = "La identificación de la ciudad ya existe.";
        return new CityIdDoesExistsException(userMessage);
    }
}