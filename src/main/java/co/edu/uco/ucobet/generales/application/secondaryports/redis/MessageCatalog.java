package co.edu.uco.ucobet.generales.application.secondaryports.redis;

public interface MessageCatalog {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}
