package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class DomainUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public DomainUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
	}
	
	public static final DomainUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new DomainUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final DomainUcobetException create(final String userMessage) {
		return new DomainUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final DomainUcobetException create(final String userMessage, final String technicalMessage) {
		return new DomainUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	