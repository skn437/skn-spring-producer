package skn.dev.producer.routes.wang;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WangRouteService implements WangRouteInterface {

  @Override
  public Mono<String> postWangRoute() {
    return Mono.just("This is Wang Route!");
  }
}
