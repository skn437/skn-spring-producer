package skn.dev.producer.routes.mails;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import skn.dev.producer.server.json.Gallery;

@Service
public class MailRouteService {

  Gallery gallery1 = new Gallery("SKN", "Dhaka", "Wang So");
  Gallery gallery2 = new Gallery("Himu", "Dhaka", "Mahapurush");

  public Flux<Gallery> getMailRoute() {
    return Flux.just(gallery1, gallery2);
  }
}
