package com.eeee.services;

import com.eeee.spike.model.User;
import com.eeee.spike.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) throws Exception {
        if (user.getEmail() == null) {
            throw new Exception("Cannot add a user without email address.");
        }

        Optional<User> u = userRepository.findByEmail(user.getEmail());
        if (u.isPresent()) {
            throw new Exception("A user with the email '" + user.getEmail() + "' already exists.");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(userRepository.getOne(id));
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        if (email == null || password == null) {
            return null;
        }

        return userRepository.findByEmailAndPassword(email, password);
    }
}
