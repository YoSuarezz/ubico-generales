package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;

public class StateDoesNotExistException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistException(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}

	public static StateDoesNotExistException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("StateDoesNotExistException");
		return new StateDoesNotExistException(userMessage);
	}

}