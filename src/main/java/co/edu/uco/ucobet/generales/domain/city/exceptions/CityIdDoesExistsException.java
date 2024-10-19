package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.enums.RuleUcobetException;

public class CityIdDoesExistsException extends RuleUcobetException {
    public CityIdDoesExistsException(final String userMessage,
                                     final String technicalMessage,
                                     final Exception rootException) {
        super(userMessage, technicalMessage, rootException);
    }
    private static final long serialVersionUTD = 1L;
}
