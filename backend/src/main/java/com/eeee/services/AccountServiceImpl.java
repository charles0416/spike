package com.eeee.services;

import com.eeee.spike.model.Account;
import com.eeee.spike.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository userRepository;

    @Autowired
    AccountServiceImpl(AccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Account add(Account user) throws Exception {
        if (user.getEmail() == null) {
            throw new Exception("Cannot add a user without email address.");
        }

        Optional<Account> u = userRepository.findByEmail(user.getEmail());
        if (u.isPresent()) {
            throw new Exception("A user with the email '" + user.getEmail() + "' already exists.");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<Account> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<Account> get(Long id) {
        return Optional.ofNullable(userRepository.getOne(id));
    }

    @Override
    public Optional<Account> authenticate(String email, String password) {
        if (email == null || password == null) {
            return null;
        }

        return userRepository.findByEmailAndPassword(email, password);
    }
}
