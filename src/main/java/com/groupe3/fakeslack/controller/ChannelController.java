package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.service.IServiceChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("channels")
public class ChannelController {

    @Autowired
    private IServiceChannel service;

    @GetMapping("")
    public ResponseEntity<List<Channel>> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Channel> getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping("")
    public void addChannel(@RequestBody Channel channel) {
        service.create(channel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    @PutMapping("")
    public void updateChannel(@RequestBody Channel channel) {
        service.update(channel);
    }
}
