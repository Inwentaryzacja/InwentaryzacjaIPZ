package Zut_IPZ.Inwentaryzacja.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
@Configuration
public class Config {
    @Bean
    public static PasswordEncoder customPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
