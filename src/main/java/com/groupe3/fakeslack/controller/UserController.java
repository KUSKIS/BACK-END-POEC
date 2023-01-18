package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private IServiceUser service;

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        System.out.println("It works");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        return service.delete(id);
    }

    @PutMapping("")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return service.update(user);
    }
}
