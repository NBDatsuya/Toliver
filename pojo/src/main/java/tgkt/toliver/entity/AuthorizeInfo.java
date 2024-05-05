package tgkt.toliver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@RedisHash("toliver_authorize_info")
public class AuthorizeInfo {
    @Id
    private int id;
    private String name;
    private LocalDateTime expires;
    private String token;
}
