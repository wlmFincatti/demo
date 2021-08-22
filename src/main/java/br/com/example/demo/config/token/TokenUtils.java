package br.com.example.demo.config.token;

import br.com.example.demo.config.exceptions.InvalidTokenException;
import br.com.example.demo.config.exceptions.TokenNotPresentException;
import br.com.example.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;

@Slf4j
@UtilityClass
public class TokenUtils {

    @Value("${api.auth.key}")
    private String API_KEY;

    public static User getUserFromToken(String token) {
        return getObjectFromToken(token, User.class);
    }

    public static Boolean isAuthorizationValid(String authorizationToken) {
        var authorization = getObjectFromToken(authorizationToken, Authorization.class);
        return authorization.getKey().contentEquals(API_KEY)
            && Duration.between(authorization.getRequestDateTime(), LocalDateTime.now()).equals(Duration.ofSeconds(10));
    }

    private static <T> T getObjectFromToken(String token, Class<T> clazz) {
        if (!StringUtils.hasText(token)) {
            throw new TokenNotPresentException();
        }

        if (clazz == Authorization.class && !token.startsWith("Bearer ")) {
            throw new InvalidTokenException();
        }

        var payload = token.split("\\.");
        var decodedBody = new String(Base64.getDecoder().decode(payload[1]));

        var objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(decodedBody, clazz);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new InvalidTokenException();
        }

    }
}
