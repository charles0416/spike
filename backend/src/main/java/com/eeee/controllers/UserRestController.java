package com.eeee.controllers;

import com.eeee.exceptions.BadRequestException;
import com.eeee.services.UserService;
import com.eeee.spike.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Charles on 15/06/2017.
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User add(@RequestBody User input) {
        User newUser = null;
        try {
            newUser = userService.add(input);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        return newUser;
    }
}
