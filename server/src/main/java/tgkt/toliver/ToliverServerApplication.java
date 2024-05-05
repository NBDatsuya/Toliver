package tgkt.toliver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@Slf4j
public class ToliverServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToliverServerApplication.class, args);
        log.info("ToliverServer started successfully");
    }

}
