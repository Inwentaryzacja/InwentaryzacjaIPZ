package Zut_IPZ.Inwentaryzacja.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return  http.csrf().disable().httpBasic().disable()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/sign_up", "/sign_up_confirm/*").permitAll();
                }).build();




    }

}

