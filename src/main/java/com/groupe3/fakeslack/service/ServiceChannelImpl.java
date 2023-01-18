package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.repository.IChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceChannelImpl implements IServiceChannel {

    @Autowired
    private IChannelRepository repository;

    @Autowired
    private ServiceMessageImpl serviceMessage;

    @Override
    public ResponseEntity<List<Channel>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity<Channel> getById(int id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }


    @Override
    public ResponseEntity<String> create(Channel channel) {
        repository.save(channel);
        return ResponseEntity.ok("Channel created!");
    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Channel deleted!");
    }

    @Override
    public ResponseEntity<String> update(Channel channel) {
        if (!repository.existsById(channel.getId())) {
            return ResponseEntity.badRequest()
                    .body("A channel with the specified id does not exist");
        }
        repository.save(channel);
        return ResponseEntity.ok("Channel updated");
    }
}
