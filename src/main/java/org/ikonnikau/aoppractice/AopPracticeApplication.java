package org.ikonnikau.aoppractice;

import org.ikonnikau.aoppractice.entity.User;
import org.ikonnikau.aoppractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopPracticeApplication.class, args);
    }
}
