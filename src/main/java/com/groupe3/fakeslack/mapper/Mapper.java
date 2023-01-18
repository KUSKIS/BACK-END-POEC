package com.groupe3.fakeslack.mapper;

import com.groupe3.fakeslack.dto.MessageDto;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    IServiceUser service;

    public MessageDto toDto(Message m) {

        MessageDto mDto = new MessageDto();
        mDto.setId(m.getId());
        mDto.setUsername(service.getById(m.getUserId()).getBody().getUsername());
        mDto.setDate(m.getDateOfCreation());
        mDto.setChannelId(m.getChannelId());
        mDto.setContent(m.getText());
        return mDto;
    }

    public Message toMessage(MessageDto mDto) {
        User u = service.findByUsername(mDto.getUsername()).getBody();
        Message m = new Message(mDto.getContent(), mDto.getDate(), u.getId(), mDto.getChannelId());
        m.setId(mDto.getId());
        m.setDateOfModification(mDto.getDate());
        return m;
    }
}
