package io.github.rogerlog.TestsMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.rogerlog.TestsMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}