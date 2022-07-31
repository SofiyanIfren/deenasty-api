package deenasty.data.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"deenasty.data.api.dao", "deenasty.data.api.service",
        "deenasty.data.api.controller", "deenasty.data.api.http"})
@EntityScan("deenasty.data.api.model")
@EnableJpaRepositories({"deenasty.data.api.dao"})
public class DeenastyDataApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeenastyDataApiApplication.class, args);
    }

}
