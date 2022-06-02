package br.com.rodpk.gamelist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.model.User;
import br.com.rodpk.gamelist.model.dto.UserRequest;
import br.com.rodpk.gamelist.model.dto.UserResponse;
import br.com.rodpk.gamelist.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponse save(UserRequest request) {
        var user = repository.save(User.of(request));

        return UserResponse.of(user);
    }

    public UserResponse find(Integer id) {
        var user = repository.findActive(id).orElseThrow(() -> new RuntimeException("user not found"));

        return UserResponse.of(user);
    }

    public UserResponse update(Integer id, UserRequest request) {
        var existingUser = repository.findActive(id).orElseThrow(() -> new RuntimeException("user not found"));
        
        var user = User.of(request);
        user.setId(existingUser.getId());

        return UserResponse.of(repository.save(user));
    }

    public void safeDelete(Integer id) {

        try {
            repository.safeDelete(id);
        } catch (Exception e) {
            throw new RuntimeException("err: " + e.getMessage());
        }

    }
}
