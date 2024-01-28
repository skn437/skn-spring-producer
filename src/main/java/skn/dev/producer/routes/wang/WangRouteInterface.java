package skn.dev.producer.routes.wang;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public abstract interface WangRouteInterface {
  public Mono<String> postWangRoute();
}
