package com.groupe3.fakeslack.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MessageDto {

    private int id;
    private String content;
    private String username;
    private LocalDateTime date;

    private int channelId;

    public MessageDto(int id, String content, String username, LocalDateTime date, int channelId) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.date = date;
        this.channelId = channelId;
    }

    public MessageDto(String content, String username, LocalDateTime date, int channelId) {
        this.content = content;
        this.username = username;
        this.date = date;
        this.channelId = channelId;
    }

    public MessageDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
