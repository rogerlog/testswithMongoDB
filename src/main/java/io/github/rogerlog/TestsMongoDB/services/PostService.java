package io.github.rogerlog.TestsMongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.rogerlog.TestsMongoDB.domain.Post;
import io.github.rogerlog.TestsMongoDB.repository.PostRepository;
import io.github.rogerlog.TestsMongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
}
