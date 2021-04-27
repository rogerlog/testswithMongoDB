package io.github.rogerlog.TestsMongoDB.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.rogerlog.TestsMongoDB.domain.User;
import io.github.rogerlog.TestsMongoDB.repository.UserRepository;
import io.github.rogerlog.TestsMongoDB.services.exception.ObjectNotFoundException;
import io.github.rogerlog.TestsMongoDB.dto.UserDTO;

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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).orElse(null);
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}