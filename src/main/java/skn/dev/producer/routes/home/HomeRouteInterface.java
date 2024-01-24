package skn.dev.producer.routes.home;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

public abstract interface HomeRouteInterface {
  public Mono<String> getHomeRoute(@RequestHeader Map<String, String> headers);
}
