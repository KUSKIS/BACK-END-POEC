package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceMessage {

    public ResponseEntity<List<Message>> getAll();

    public Message getById(int id);

    public ResponseEntity<String> create(Message message);

    public ResponseEntity<String> update(Message message);

    public ResponseEntity<String> delete(int id);

    public List<Message> getAllByChannelId(int id);
}
