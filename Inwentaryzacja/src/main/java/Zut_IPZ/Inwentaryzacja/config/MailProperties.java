package Zut_IPZ.Inwentaryzacja.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.properties")
public class MailProperties {
    private String username;
    private String password;
}