package skn.dev.producer.routes.skn;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SknRouteService implements SknRouteInterface {

  @Override
  public Mono<String> getSknRoute() {
    return Mono.just(String.format("This is SKN \n"));
  }
}
