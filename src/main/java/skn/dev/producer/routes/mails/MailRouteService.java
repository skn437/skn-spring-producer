package skn.dev.producer.routes.mails;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import skn.dev.producer.server.json.Gallery;

@Service
public class MailRouteService implements MailRouteInterface {

  private Gallery gallery1 = new Gallery("SKN", "Dhaka", "Wang So");
  private Gallery gallery2 = new Gallery("Himu", "Dhaka", "Mahapurush");

  Logger logger = Logger.getLogger(MailRouteService.class.getName());

  @Override
  public Flux<Gallery> getMailRoute() {
    try {
      return Flux.just(this.gallery1, this.gallery2);
    } catch (Exception e) {
      logger.log(Level.SEVERE, "SKN is Wang So!");

      return Flux.just(new Gallery());
    }
  }

  @Override
  public Flux<Gallery> postMailRoute(
    String title,
    String src,
    String alt,
    Map<String, String> headers
  ) {
    Gallery galleryData = new Gallery(title, src, alt);

    try {
      if (headers.get("post").equals("posted")) {
        return Flux.just(galleryData);
      }
      return Flux.just(new Gallery());
    } catch (Exception e) {
      System.out.printf("Error: %s \n", e.getMessage());
      return Flux.just(new Gallery());
    }
  }
}
