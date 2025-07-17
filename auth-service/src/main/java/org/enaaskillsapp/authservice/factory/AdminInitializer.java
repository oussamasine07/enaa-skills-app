package org.enaaskillsapp.authservice.factory;


import org.enaaskillsapp.authservice.model.Admin;
import org.enaaskillsapp.authservice.model.User;
import org.enaaskillsapp.authservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createAdmin (UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if  (userRepository.findUserByEmail("sine@gmail.com") == null) {
                User newUser = new Admin();

                newUser.setFirstName("oussama");
                newUser.setLastName("sine");
                newUser.setEmail("sine@gmail.com");
                newUser.setPassword(encoder.encode("123456"));

                userRepository.save(newUser);

            } else {
                System.out.println("this user is already exists");
            }
        };
    }

}
