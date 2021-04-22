package io.github.rogerlog.TestsMongoDB.config;

import io.github.rogerlog.TestsMongoDB.domain.User;
import io.github.rogerlog.TestsMongoDB.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria", "maria@gmail.com");
        User alex = new User(null, "Alex", "alex@dominio.com");
        User joao = new User(null, "Joao", "joao@dominio.com");

        userRepository.saveAll(Arrays.asList(maria, alex, joao));
    }
}