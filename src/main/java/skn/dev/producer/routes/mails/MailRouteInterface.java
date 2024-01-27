package skn.dev.producer.routes.mails;

import java.util.Map;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import skn.dev.producer.server.json.Gallery;

@Component
public abstract interface MailRouteInterface {
  public Flux<Gallery> getMailRoute();

  public Flux<Gallery> postMailRoute(
    String title,
    String src,
    String alt,
    Map<String, String> headers
  );
}
