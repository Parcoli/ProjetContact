package org.example.accessingDataJPA;

import org.example.accessingDataJPA.Contact;
import org.example.accessingDataJPA.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ContactRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Contact("Jack", "Bauer","test","test.test@gmail.com"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Contact contact : repository.findAll()) {
                log.info(contact.toString());
            }
            log.info("");

        };
    }

}