package skn.dev.producer.routes.mails;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import skn.dev.producer.server.json.Gallery;

@Service
public class MailRouteService {

  private Gallery gallery1 = new Gallery("SKN", "Dhaka", "Wang So");
  private Gallery gallery2 = new Gallery("Himu", "Dhaka", "Mahapurush");

  Logger logger = Logger.getLogger(MailRouteService.class.getName());

  public Flux<Gallery> getMailRoute() {
    try {
      return Flux.just(this.gallery1, this.gallery2);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "SKN is Wang So!");

      return Flux.just(new Gallery());
    }
  }
}
