package com.eeee.controllers;

import com.eeee.exceptions.BadRequestException;
import com.eeee.services.AccountService;
import com.eeee.spike.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Charles on 15/06/2017.
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private AccountService userService;

    @Autowired
    public UserRestController(AccountService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account add(@RequestBody Account input) {
        Account newUser = null;
        try {
            newUser = userService.add(input);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        return newUser;
    }
}
