package skn.dev.producer.security.controllers;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/csrf")
public class CsrfRouteController {

  @GetMapping
  public Mono<CsrfToken> getCsrf(CsrfToken token) {
    return Mono.just(token);
  }
}
