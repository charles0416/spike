package com.eeee.controllers;

import com.eeee.exceptions.AuthorizeException;
import com.eeee.exceptions.BadRequestException;
import com.eeee.services.UserService;
import com.eeee.spike.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
@RestController
@RequestMapping("/api/authenticate")
public class AuthenticateController {

    private UserService userService;

    @Autowired
    public AuthenticateController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User authenticate(@RequestBody User user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new BadRequestException("Invalid email or password.");
        }

        Optional<User> authenticatedUser = userService.authenticate(user.getEmail(), user.getPassword());

        if (!authenticatedUser.isPresent()) {
            throw new AuthorizeException("Incorrect email or password.");
        }

        return authenticatedUser.get();
    }

}
