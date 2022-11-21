package me.code.webservicesspringbootcaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebServicesSpringBootCachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServicesSpringBootCachingApplication.class, args);
    }

}
