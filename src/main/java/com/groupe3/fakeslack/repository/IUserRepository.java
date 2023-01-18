package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByChannels_id(int channelId);
}