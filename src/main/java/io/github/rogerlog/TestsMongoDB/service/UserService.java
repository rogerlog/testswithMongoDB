package io.github.rogerlog.TestsMongoDB.service;

import io.github.rogerlog.TestsMongoDB.domain.User;
import io.github.rogerlog.TestsMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();

    }
}
