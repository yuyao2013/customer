package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {

    private RestTemplate restTemplate = new RestTemplate();

    private String url = "http://order:9001";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping("/")
    public String home(@RequestParam(required = false, defaultValue = "yuzhen") String name) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HttpHeaders.ACCEPT, "*/*");
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url + "?name=" + name, HttpMethod.GET, requestEntity,
                String.class);

        if (response.getStatusCode() != HttpStatus.NOT_MODIFIED) {
            System.out.println("rtn:" + response.getBody());
        }

        return "customer-order:" + response.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
