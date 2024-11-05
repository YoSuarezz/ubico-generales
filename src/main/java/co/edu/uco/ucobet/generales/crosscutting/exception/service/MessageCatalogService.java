package co.edu.uco.ucobet.generales.crosscutting.exception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageCatalogService {

    private final StringRedisTemplate redisTemplate;
    private static final String FALLBACK_MESSAGE = "Mensaje no encontrado en Redis o revise la conexion.";

    @Autowired
    public MessageCatalogService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getMessage(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String getMessageOrDefault(String key) {
        String message = redisTemplate.opsForValue().get(key);
        return (message != null) ? message : FALLBACK_MESSAGE;
    }
}
