package pl.zak.component30;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.zak.component30.entity.Offer;
import pl.zak.component30.repository.OfferRepository;

import java.util.Arrays;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
@EnableScheduling
public class Component30Application {
    public static void main(String[] args) {
        SpringApplication.run(Component30Application.class, args);
    }
}
