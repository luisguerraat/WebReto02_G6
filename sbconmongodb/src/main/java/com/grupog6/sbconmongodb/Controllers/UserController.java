package com.grupog6.sbconmongodb.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupog6.sbconmongodb.Documents.User;

import com.grupog6.sbconmongodb.Services.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/emailexist/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean getValidateEmail(@PathVariable String email) {
        return userService.getValidateEmail(email);
    }

    @GetMapping("/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    public User getLogin(@PathVariable String email, @PathVariable String password) {
        return userService.getLogin(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
    public User udpUser(@RequestBody User user) {
        return userService.udpUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delUser(@PathVariable Integer id) {
         userService.delUser(id);
    }
    
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }


    
}

