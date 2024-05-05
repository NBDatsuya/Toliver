package tgkt.toliver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tgkt.toliver.entity.SystemUser;
import tgkt.toliver.properties.JWTProperties;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
@Configuration
public class JWTUtil {
    @Autowired
    private JWTProperties jwtProperties;

    public DecodedJWT resolveJWT(String headerToken) {
        String token = convertToken(headerToken);
        if (token == null) return null;

        var key = jwtProperties.getKey();
        var algorithm = Algorithm.HMAC256(key);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verifyResult = verifier.verify(token);

            // Is token valid?
            //if (isInvalidToken(verifyResult.getId())) return null;

            // Is token expired?
            var expiresAt = verifyResult.getExpiresAt();
            return new Date().after(expiresAt) ? null : verifyResult;

        } catch (JWTVerificationException e) {
            return null;
        }
    }

    public String createJWT(SystemUser user, LocalDateTime expireTime) {
        var key = jwtProperties.getKey();
        var algorithm = Algorithm.HMAC256(key);
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("id", user.getId())
                .withClaim("name", user.getName())
                .withExpiresAt(
                        expireTime == null ?
                                expireTime().toInstant(ZoneOffset.UTC) :
                                expireTime.toInstant(ZoneOffset.UTC))
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    public LocalDateTime expireTime() {
        var expires = jwtProperties.getExpires();
        return LocalDateTime.now().plusHours(24L * expires);
    }

    private String convertToken(String header) {
        if (header == null || !header.startsWith("Bearer")) return null;
        return header.substring(7);
    }

    public <T extends SystemUser> SystemUser toUser(DecodedJWT jwt) {
        var claims = jwt.getClaims();
        return T.builder()
                .name(claims.get("name").asString())
                .password("******")
                .build();
    }

    public String toId(DecodedJWT jwt) {
        return jwt.getClaims().get("id").asString();
    }

    public boolean invalidateJWT(String headerToken) {
        var token = convertToken(headerToken);
        if (token == null) return false;
        var key = jwtProperties.getKey();
        var algorithm = Algorithm.HMAC256(key);
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            var jwtId = jwt.getId();
            return true;
            //deleteTokenAndRecord(jwtId, jwt.getExpiresAt());
        } catch (JWTVerificationException e) {
            return false;
        }
    }
    /*

    private boolean deleteTokenAndRecord(String jwtId, Date time) {
        if (isInvalidToken(jwtId)) return false;

        long expire = Math.max(0, time.getTime() - new Date().getTime());
        template.opsForValue().set(ResponseConstant.PREFIX_JWT_BLACKLIST + jwtId,
                "", expire, TimeUnit.MILLISECONDS);
        return true;
    }*/

/*
    private boolean isInvalidToken(String jwtId) {
        return Boolean.TRUE.equals(
                template.hasKey(
                        ResponseConstant.PREFIX_JWT_BLACKLIST
                                + jwtId
                ));
    }*/
}
