package io.github.rogerlog.TestsMongoDB.config;

import io.github.rogerlog.TestsMongoDB.domain.User;
import io.github.rogerlog.TestsMongoDB.domain.Post;
import io.github.rogerlog.TestsMongoDB.repository.UserRepository;
import io.github.rogerlog.TestsMongoDB.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria", "maria@gmail.com");
        User alex = new User(null, "Alex", "alex@dominio.com");
        User joao = new User(null, "Joao", "joao@dominio.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
        userRepository.saveAll(Arrays.asList(maria, alex, joao));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
