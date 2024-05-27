package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Service;
@Data
public class Note {
    private int id = 1;
    private String title = "";
    private String content = "";

    public Note() {
    }
    public Note(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }
}
