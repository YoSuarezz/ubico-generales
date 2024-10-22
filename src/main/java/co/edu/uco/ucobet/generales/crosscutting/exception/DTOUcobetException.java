package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class DTOUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public DTOUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}
	
	public static final DTOUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DTOUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final DTOUcobetException create(final String userMessage) {
		return new DTOUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final DTOUcobetException create(final String userMessage, final String technicalMessage) {
		return new DTOUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	