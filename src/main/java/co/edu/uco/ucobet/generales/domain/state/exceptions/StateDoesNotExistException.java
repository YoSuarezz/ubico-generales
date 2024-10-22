package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class StateDoesNotExistException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistException create() {
		var userMessage = "El estado no existe existe.";
		return new StateDoesNotExistException(userMessage);
	}

}
