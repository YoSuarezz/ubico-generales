package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;


public class StateIdIsDefaultValueException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsDefaultValueException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("StateIdIsDefaultValueException");
		return new StateIdIsDefaultValueException(userMessage);
	}

}