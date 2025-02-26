package nineonesoft.todo;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "spring.datasource")
public class Properties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
