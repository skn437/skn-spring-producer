package skn.dev.producer.routes.home;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HomeRouteController implements HomeRouteInterface {

  @Autowired
  private HomeRouteService homeRouteService;

  @GetMapping
  @Override
  public Mono<String> getHomeRoute(@RequestHeader Map<String, String> headers) {
    return this.homeRouteService.getHomeRoute(headers);
  }
}
