package htw.berlin.webtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "htw.berlin.webtech")
@EnableJpaRepositories(basePackages = "htw.berlin.webtech.repository")
public class WebtechApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebtechApplication.class, args);
    }
}
