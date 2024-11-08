package co.edu.uco.ucobet.generales.application.secondaryports.messages;

public interface MessageCatalogInterface {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}
