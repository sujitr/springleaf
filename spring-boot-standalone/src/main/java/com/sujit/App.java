package com.sujit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
       return args -> {
            System.out.println(">>> Standalone Spring Boot application - Hello World!!!");   
       };
    }
}
