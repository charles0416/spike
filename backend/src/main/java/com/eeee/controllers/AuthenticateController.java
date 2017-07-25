package com.eeee.controllers;

import com.eeee.exceptions.AuthorizationException;
import com.eeee.exceptions.BadRequestException;
import com.eeee.services.AccountService;
import com.eeee.spike.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by Charles on 15/06/2017.
 */
@RestController
@RequestMapping("/api/authenticate")
public class AuthenticateController {

    private AccountService userService;

    @Autowired
    public AuthenticateController(AccountService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account authenticate(@RequestBody Account user) {
        if (user == null || user.getEmail() == null || user.getPassword() == null) {
            throw new BadRequestException("Invalid email or password.");
        }

        Optional<Account> authenticatedUser = userService.authenticate(user.getEmail(), user.getPassword());

        if (!authenticatedUser.isPresent()) {
            throw new AuthorizationException("Incorrect email or password.");
        }

        return authenticatedUser.get();
    }


    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    RestError handleAuthenticationError(HttpServletRequest req, AuthorizationException ex) {
        return new RestError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), req.getRequestURI());
    }
}
