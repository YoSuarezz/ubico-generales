package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.service;

public interface MessageCatalogInterface {
    String getMessage(String key);
    String getMessageOrDefault(String key);
}
