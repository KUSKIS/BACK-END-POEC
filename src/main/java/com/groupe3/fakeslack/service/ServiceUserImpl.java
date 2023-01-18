package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUserImpl implements IServiceUser {

    @Autowired
    IUserRepository repository;

    @Autowired
    ServiceChannelImpl serviceChannel;

    @Override
    public ResponseEntity<List<User>> getAll() {
        //try {
        List<User> users = repository.findAll();
        //if (!users.isEmpty()) {
        return ResponseEntity.ok(users);
        // }
        // return ResponseEntity.badRequest()
        //         .body("There are no users in the database");
        //} catch (Exception ex) {
        //   return ResponseEntity.internalServerError()
        //           .body("An error occurred while trying to retrieve the users: " + ex.getMessage());
        //}
    }


    @Override
    public ResponseEntity<User> getById(int id) {
        //try {

        //  if (repository.findById(id).isPresent()) {
        //
        //return ResponseEntity.ok(repository.findById(id).get());
        return ResponseEntity.ok(repository.findById(id).orElse(null));
        //
        // }
        //return ResponseEntity.badRequest()
        //      .body("An user with the specified id does not exist");
        //} catch (DataIntegrityViolationException ex) {
        //  return ResponseEntity.badRequest()
        //        .body("The user data violates a database constraint. " +
        //              "Please verify that the name and id are unique and meet any other database constraints.");
        //} catch (Exception ex) {
        //   return ResponseEntity.internalServerError()
        //          .body("An error occurred while trying to retrieve the user: " + ex.getMessage());
        //}
    }

    @Override
    public ResponseEntity<User> findByUsername(String username) {
        User user = repository.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


    @Override
    public ResponseEntity<List<User>> getUsersForChannel(int id) {

        List<User> users = repository.findByChannels_id(id);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    /*
    @Override
    public ResponseEntity<String> create(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
    }
    */
    @Override
    public ResponseEntity<String> create(User user) {
        //try {
        //    if (repository.findOne(Example.of(user)).isPresent()) {
        //        return ResponseEntity.badRequest()
        //                .body("this user already exists");
        //  }
        // user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
        return ResponseEntity.ok("User successfully created");
        //} catch (DataIntegrityViolationException ex) {
        //  return ResponseEntity.badRequest()
        //        .body("The user data violates a database constraint. " +
        //              "Please verify that the name and id are unique and meet any other database constraints.");
        //} catch (Exception ex) {
        //    return ResponseEntity.internalServerError()
        //          .body("An error occurred while trying to create the user: " + ex.getMessage());
        // }
    }


    @Override
    public ResponseEntity<String> delete(int id) {

        //try {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("User successfully deleted");
        }

        return ResponseEntity.badRequest().body("A user with the specified id does not exist");

        //} catch (DataIntegrityViolationException ex) {
        //    return ResponseEntity.badRequest()
        //            .body("The user cannot be deleted because it is being referenced by another entity. " +
        //                    "Please delete the other entity first.");

        //} catch (Exception ex) {
        //   return ResponseEntity.internalServerError()
        //          .body("An error occurred while trying to delete the user: " + ex.getMessage());
        //}
    }


    @Override
    public ResponseEntity<String> update(User user) {
        //try {
        if (!repository.existsById(user.getId())) {
            return ResponseEntity.badRequest().body("A user with the specified id does not exist");
        }

        // if (repository.findOne(Example.of(user)).isPresent()) {
        //     return ResponseEntity.badRequest()
        //             .body("This user already exists");
        //}
        repository.save(user);
        return ResponseEntity.ok("User successfully updated");
        //} catch (DataIntegrityViolationException ex) {
        //  return ResponseEntity.badRequest()
        //        .body("The user data violates a database constraint. " +
        //              "Please verify that the name and id are unique and meet any other database constraints.");
        //} catch (Exception ex) {
        //  return ResponseEntity.internalServerError()
        //        .body("An error occurred while trying to update the user: " + ex.getMessage());
        //}
    }

}

