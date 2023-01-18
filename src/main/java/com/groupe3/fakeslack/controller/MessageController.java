package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.dto.MessageDto;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.mapper.Mapper;
import com.groupe3.fakeslack.service.IServiceMessage;
import com.groupe3.fakeslack.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private IServiceMessage service;

    @Autowired
    private IServiceUser serviceUser;

    @Autowired
    private Mapper mapper;


    @GetMapping("")
    public List<MessageDto> getAll() {

        ResponseEntity<List<Message>> messages = service.getAll();
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message m : messages.getBody()) {
            messageDtos.add(mapper.toDto(m));
        }
        return messageDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(mapper.toDto(service.getById(id)));
    }

    @PostMapping("")
    public ResponseEntity<String> addMessage(@RequestBody MessageDto mDto) {
        mDto.setDate(LocalDateTime.now());
        return service.create(mapper.toMessage(mDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id) { return service.delete(id); }

    @PutMapping("")
    public ResponseEntity<String> updateMessage(@RequestBody MessageDto mDto) {
        Message m = service.getById(mDto.getId());
        int userId = m.getUserId();
        User u = serviceUser.getById(userId).getBody();
        mDto.setUsername(u.getUsername());
        mDto.setDate(LocalDateTime.now());
        mDto.setChannelId(m.getChannelId());
        return service.update(mapper.toMessage(mDto));
    }

    @GetMapping("/channel/{id}")
    public List<MessageDto> getByChannelId(@PathVariable("id") int id) {

        List<Message> messages = service.getAllByChannelId(id);
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message m : messages) {
            messageDtos.add(mapper.toDto(m));
        }

        return messageDtos;
    }

}
