package br.com.diego.msfluxocaixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.diego.msfluxocaixa")
public class MsfluxocaixaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsfluxocaixaApplication.class, args);
    }

}
