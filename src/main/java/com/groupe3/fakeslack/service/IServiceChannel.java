package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;

import java.util.List;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IServiceChannel {

    public ResponseEntity<List<Channel>> getAll();

    public ResponseEntity<Channel> getById(int id);

    public ResponseEntity<String> create(Channel channel);

    public ResponseEntity<String> update(Channel channel);

    public ResponseEntity<String> delete(Integer id);
}
