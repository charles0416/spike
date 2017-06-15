package com.eeee.services;

import com.eeee.spike.model.User;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
public interface UserService {
    public User add(User user) throws Exception;
    public Optional<User> getByEmail(String email);
    public Optional<User> get(Long id);
    public Optional<User> authenticate(String email, String password);
}
