package skn.dev.producer.routes.skn;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public abstract interface SknRouteInterface {
  public Mono<String> getSknRoute();
}
