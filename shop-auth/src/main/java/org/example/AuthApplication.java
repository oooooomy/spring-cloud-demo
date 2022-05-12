package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Gao Yuan Ming
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("shop-user"));
        SpringApplication.run(AuthApplication.class, args);
    }

}
