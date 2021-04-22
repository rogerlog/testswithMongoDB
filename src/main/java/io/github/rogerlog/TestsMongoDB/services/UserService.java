package io.github.rogerlog.TestsMongoDB.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.rogerlog.TestsMongoDB.domain.User;
import io.github.rogerlog.TestsMongoDB.repository.UserRepository;
import io.github.rogerlog.TestsMongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
}