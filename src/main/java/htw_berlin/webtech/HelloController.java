package htw_berlin.webtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/data")
    public String getData() {
        return "Hello from the Spring Boot backend!";
    }
}
