package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IMessageRepository extends JpaRepository<Message, Integer> {

    public List<Message> findByChannelId(int id);
}
