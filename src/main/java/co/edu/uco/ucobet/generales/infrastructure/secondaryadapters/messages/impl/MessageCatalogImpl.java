package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.impl;

import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogImpl implements MessageCatalog {

    private final StringRedisTemplate redisTemplate;
    private static final String FALLBACK_MESSAGE = "Mensaje no encontrado en Redis o revise la conexion.";

    @Autowired
    public MessageCatalogImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getMessageOrDefault(String key) {
        String message = redisTemplate.opsForValue().get(key);
        return (message != null) ? message : FALLBACK_MESSAGE;
    }
}