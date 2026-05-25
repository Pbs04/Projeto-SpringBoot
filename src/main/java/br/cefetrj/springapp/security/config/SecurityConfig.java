package br.cefetrj.springapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import br.cefetrj.springapp.security.CustomAuthEntryPoint;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    // @Autowired
    // private UsuarioService usuarioService;

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation("https://accounts.google.com");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource)
            throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(csrf -> csrf.disable()) // IMPORTANTE: Desabilita CSRF para APIs
                .authorizeHttpRequests(authz -> authz

                        .requestMatchers("/auth/google/**")
                        .permitAll()
                        .anyRequest().authenticated())
                // .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
                // SE Não Fosse restful.oauth2Login(oauth -> oauth.loginPage("/login"))
                .oauth2ResourceServer(oauth2 -> oauth2
                        .authenticationEntryPoint(new CustomAuthEntryPoint())
                        .jwt(jwt -> {
                        }));
        // CustomJwtAuthConverter(usuarioService))));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}