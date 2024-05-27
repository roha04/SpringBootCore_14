package com.example.demo.service;

import com.example.demo.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(Long id);
    void deleteLast();
    void update(Note note);
    Note getById(Long id);
}
