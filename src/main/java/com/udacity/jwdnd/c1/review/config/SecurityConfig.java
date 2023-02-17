package com.udacity.jwdnd.c1.review.config;

import com.udacity.jwdnd.c1.review.services.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/signup", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationProvider(this.authenticationService)

                .formLogin((form) -> form
                    .loginPage("/login")
                    .permitAll()
                )

                .formLogin((form) -> form
                .defaultSuccessUrl("/chat", true))

                .logout().logoutSuccessUrl("/login");
        return http.build();
    }
}
