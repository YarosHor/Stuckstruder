package com.yaros.stuckstruder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StuckstruderSpringApp {
    public static void main(String[] args) {
        SpringApplication.run(StuckstruderSpringApp.class, args);
    }

    /*
    //run this the first time or create a new user at database
    @Bean
    public CommandLineRunner initData(UserService userService) {
        return args -> {
            UserModel user = new UserModel(null,null,"user@mail.com","hidden");
            userService.register(user);
        };
    }
     */
}
