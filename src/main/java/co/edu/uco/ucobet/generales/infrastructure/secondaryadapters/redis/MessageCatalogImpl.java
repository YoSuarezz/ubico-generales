package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.application.secondaryports.redis.MessageCatalog;
import java.util.Objects;
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
        return (!Objects.equals(message, TextHelper.EMPTY)) ? message : FALLBACK_MESSAGE;
    }
}