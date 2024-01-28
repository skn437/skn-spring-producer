package skn.dev.producer.security.controllers;

import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CsrfControllerAdvice {

  @ModelAttribute
  Mono<CsrfToken> csrfToken(ServerWebExchange exchange) throws Exception {
    String csrf = CsrfToken.class.getName();

    if (csrf == null) throw new Exception("Token Name Is Null!");

    Mono<CsrfToken> csrfToken = exchange.getAttribute(csrf);

    if (csrfToken == null) throw new Exception("Token Not Found!");

    return csrfToken.doOnSuccess(token ->
      exchange
        .getAttributes()
        .put(CsrfRequestDataValueProcessor.DEFAULT_CSRF_ATTR_NAME, token)
    );
  }
}
