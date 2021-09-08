package ru.filimonov.hotelbusinessdatagenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
public class SpringJpaPostgresApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaPostgresApp.class, args);
        AppProperties properties = context.getBean(AppProperties.class);
        properties.generate();
    }
}
