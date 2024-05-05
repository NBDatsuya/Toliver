package tgkt.toliver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.security.jwt")
@Data
public class JWTProperties {
    private String key;
    private Integer expires;
}
