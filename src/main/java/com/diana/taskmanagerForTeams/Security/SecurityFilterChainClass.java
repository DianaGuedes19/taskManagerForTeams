package com.diana.taskmanagerForTeams.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityFilterChainClass {

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/user/getAllUsers").permitAll()
                        .requestMatchers("/user/findByEmail").permitAll()
                        .requestMatchers("/user/findByUsername").permitAll()
                        .requestMatchers("/user/update/**").permitAll()
                        .requestMatchers("/api/createItem").permitAll()
                        .requestMatchers("/api/getAllItens").permitAll()
                        .requestMatchers("/api/UpdateItens/**").permitAll()
                        .requestMatchers("/api/deleteItem/**").permitAll()
                        .requestMatchers("/api/findUserAssign").permitAll()
                        .requestMatchers("/api/countItemBought").permitAll()
                        .requestMatchers("/api/filterUserByPurchase").permitAll()
                        .anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults());


        return http.build();
}



}
