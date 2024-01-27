package skn.dev.producer.routes.skn;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/skn")
public class SknRouteController {

  @Autowired
  private SknRouteService sknRouteService;

  @GetMapping
  public Mono<String> getSknRoute(
    @RequestParam(required = false, name = "id") String id
  ) {
    if (id != null) {
      return Mono.just(String.format("ID: %s \n", id));
    }

    return this.sknRouteService.getSknRoute();
  }

  @GetMapping("/wang")
  public Mono<String> getSknWangRoute(
    @RequestParam(required = false) Map<String, String> query
  ) {
    if (query.entrySet().size() != 0) {
      return Mono.just(String.format("Params: %s \n", query.entrySet()));
    }

    return Mono.just("You are good to go!");
  }
}
