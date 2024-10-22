package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class EntityUcobetException extends UcobetException{

	private static final long serialVersionUID = 1L;

	public EntityUcobetException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}
	
	public static final EntityUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException) {
		return new EntityUcobetException(userMessage, technicalMessage, rootException);
	}
	
	public static final EntityUcobetException create(final String userMessage) {
		return new EntityUcobetException(userMessage, userMessage, new Exception());
	}
	
	public static final EntityUcobetException create(final String userMessage, final String technicalMessage) {
		return new EntityUcobetException(userMessage, technicalMessage, new Exception());
	}

}
	