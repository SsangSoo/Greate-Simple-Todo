package nineonesoft.todo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Slf4j
@ConfigurationPropertiesScan
@SpringBootApplication
public class TodoApplication {

    private final Properties properties;

    public TodoApplication(final Properties properties) {
        this.properties = properties;
    }


    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        log.info("url = {}", properties.getUrl());
        log.info("username = {}", properties.getUsername());
        log.info("password = {}", properties.getPassword());
        log.info("driver =  {}", properties.getDriverClassName());
    }


}
