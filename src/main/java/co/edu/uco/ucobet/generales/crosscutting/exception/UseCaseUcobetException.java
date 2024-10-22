package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class UseCaseUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public UseCaseUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.USECASE);
	}
	
	public static final UseCaseUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new UseCaseUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final UseCaseUcobetException create(final String userMessage) {
		return new UseCaseUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final UseCaseUcobetException create(final String userMessage, final String technicalMessage) {
		return new UseCaseUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	