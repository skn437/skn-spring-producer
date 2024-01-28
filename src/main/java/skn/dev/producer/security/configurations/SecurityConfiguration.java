package skn.dev.producer.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(
    ServerHttpSecurity http
  ) {
    return http
      .authorizeExchange(exchange ->
        exchange.pathMatchers("/csrf", "/skn").permitAll()
      )
      // .csrf(csrf ->
      //   csrf.csrfTokenRepository(
      //     CookieServerCsrfTokenRepository.withHttpOnlyFalse()
      //   )
      // )
      .build();
  }
}
