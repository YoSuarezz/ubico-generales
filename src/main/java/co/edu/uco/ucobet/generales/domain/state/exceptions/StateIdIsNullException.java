package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private StateIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsNullException create(MessageCatalog messageCatalog) {
		var userMessage = messageCatalog.getMessageOrDefault("StateIdIsNullException");
		return new StateIdIsNullException(userMessage);
	}

}