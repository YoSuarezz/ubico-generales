package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service.MessageCatalogService;

public class StateDoesNotExistException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateDoesNotExistException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistException create(MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessageOrDefault("StateDoesNotExistException");
		return new StateDoesNotExistException(userMessage);
	}

}
