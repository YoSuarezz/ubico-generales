package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class ApplicationUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public ApplicationUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.APPLICATION);
	}
	
	public static final ApplicationUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new ApplicationUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final ApplicationUcobetException create(final String userMessage) {
		return new ApplicationUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final ApplicationUcobetException create(final String userMessage, final String technicalMessage) {
		return new ApplicationUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	