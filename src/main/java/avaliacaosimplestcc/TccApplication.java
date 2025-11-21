package avaliacaosimplestcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "avaliacaosimplestcc.model")
@EnableJpaRepositories(basePackages = "avaliacaosimplestcc.repository")


public class TccApplication {
    public static void main(String[] args) {
        SpringApplication.run(TccApplication.class, args);
    }
}

