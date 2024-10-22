package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class GeneralUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public GeneralUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.GENERAL);
	}
	
	public static final GeneralUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new GeneralUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final GeneralUcobetException create(final String userMessage) {
		return new GeneralUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final GeneralUcobetException create(final String userMessage, final String technicalMessage) {
		return new GeneralUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	