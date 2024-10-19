package co.edu.uco.ucobet.generales.crosscutting.enums;

public class RepositoryUcobetException extends UcobetException{

    private static final long serialVersionUID = 1L;

    public RepositoryUcobetException(final String userMessage,
                                     final String technicalMessage,
                                     final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
    }
    public static final RepositoryUcobetException create(final String userMessage,
                                                         final String technicalMessage,
                                                         final Exception rootException){
        return new RepositoryUcobetException(userMessage,technicalMessage, rootException);
    }

    public static final RepositoryUcobetException create(final String userMessage){
        return new RepositoryUcobetException(userMessage, userMessage, new Exception());
    }

    public static final RepositoryUcobetException create(final String userMessage,
                                                         final String technicalMessage){
        return new RepositoryUcobetException(userMessage, technicalMessage, new Exception());
    }
}
