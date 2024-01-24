package skn.dev.producer.routes.home;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

@Service
public class HomeRouteService implements HomeRouteInterface {

  private String name = "SKN";
  private String token = "token";

  @Override
  public Mono<String> getHomeRoute(@RequestHeader Map<String, String> headers) {
    try {
      if (
        headers.get("skn").equals("wangso") &&
        headers.get("token").equals("437")
      ) {
        return Mono.just(String.format("Hello %s \n", name));
      }

      return Mono.just(String.format("Token Mismatched!", token));
    } catch (Exception e) {
      return Mono.just(String.format("Error Occured: %s", e.getMessage()));
    }
  }
}
