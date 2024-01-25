package skn.dev.producer.routes.mails;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import skn.dev.producer.server.json.Gallery;

@RestController
@RequestMapping("/mail")
public class MailRouteController {

  @Autowired
  private MailRouteService mailRouteService;

  @GetMapping
  public Flux<Gallery> getGalleries() {
    return this.mailRouteService.getMailRoute();
  }

  @PostMapping
  public Flux<Gallery> postGallery(
    @RequestBody Gallery gallery,
    @RequestHeader Map<String, String> headers
  ) {
    Gallery galleryData = new Gallery(
      gallery.getTitle(),
      gallery.getSrc(),
      gallery.getAlt()
    );

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
