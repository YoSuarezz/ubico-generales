package co.edu.uco.ucobet.generales.infrastructure.primaryadapters.controller.secondaryadapters.messages;

public interface MessageCatalog {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}