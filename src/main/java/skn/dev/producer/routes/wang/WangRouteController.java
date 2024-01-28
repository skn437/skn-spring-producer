package skn.dev.producer.routes.wang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wang")
public class WangRouteController {

  @Autowired
  private WangRouteService wangRouteService;

  @PostMapping
  public Mono<String> postWangRoute() {
    return this.wangRouteService.postWangRoute();
  }
}
