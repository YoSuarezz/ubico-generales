package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private StateIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsNullException create() {
		var userMessage = "El Id del estado no puede ser nulo";
		return new StateIdIsNullException(userMessage);
	}

}
