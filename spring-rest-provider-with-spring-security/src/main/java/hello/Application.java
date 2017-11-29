package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import security.SecurityConfig;

@SpringBootApplication
public class Application { 
    
    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new SecurityConfig(); 
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}