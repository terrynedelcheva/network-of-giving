package com.vmware.talentboost.finaltask.networkofgiving.controllers;
import com.vmware.talentboost.finaltask.networkofgiving.model.User;
import com.vmware.talentboost.finaltask.networkofgiving.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User getUserByUsername(@PathVariable String username) {
        return this.userService.getUserByUsername(username);
    }
}
