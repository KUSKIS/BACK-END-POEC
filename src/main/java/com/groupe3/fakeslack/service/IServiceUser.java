package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceUser {
    public ResponseEntity<List<User>> getAll();

    public ResponseEntity<User> getById(int id);

    ResponseEntity<List<User>> getUsersForChannel(int id);

    public ResponseEntity<String> create(User user);

    public ResponseEntity<String> update(User user);

    public ResponseEntity<String> delete(int id);

    public ResponseEntity<User> findByUsername(String name);

}
