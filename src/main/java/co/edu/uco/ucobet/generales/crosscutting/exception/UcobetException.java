package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class UcobetException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public String userMessage;
    private Layer layer;

    public UcobetException(final String userMessage,
                           final String technicalMessage, final Exception rootException,
                           final Layer layer){
        super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),
                ObjectHelper.getDefault(rootException, new Exception()));
        setUserMessage(userMessage);
    }

    public String getUserMessage(){
        return userMessage;
    }

    private void setUserMessage(String userMessage) {
        this.userMessage = TextHelper.applyTrim(userMessage);
    }

    public Layer getLayer() {
        return layer;
    }

    private void setLayer(Layer layer) {
        this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
    }
}
