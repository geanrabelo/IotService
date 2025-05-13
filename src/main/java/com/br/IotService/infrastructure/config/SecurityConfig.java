package com.br.IotService.infrastructure.config;

import com.br.IotService.infrastructure.filter.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/v1/iot/alert/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.POST, "/v1/iot/event/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.POST, "/v1/iot/device/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.DELETE, "/v1/iot/alert/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.DELETE, "/v1/iot/event/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.DELETE, "/v1/iot/device/**").hasAnyRole("ADMIN", "TECHNICIAN")
                        .requestMatchers(HttpMethod.GET, "/v1/iot/device/**").hasRole("AUDITOR")
                        .requestMatchers(HttpMethod.GET, "/v1/iot/event/**").hasRole("AUDITOR")
                        .requestMatchers(HttpMethod.GET, "/v1/iot/alert/**").hasRole("AUDITOR")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}