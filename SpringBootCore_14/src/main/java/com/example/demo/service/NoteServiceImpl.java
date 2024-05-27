package com.example.demo.service;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteListRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteListRepository noteListRepository;
    @Override
    public List<Note> listAll() {
        return noteListRepository.listAllNotes();
    }
    @Override
    public Note add(Note note) {
        return noteListRepository.addNote(note);
    }
    @Override
    public void deleteById(Long id) {
        noteListRepository.removeNoteById(id);
    }

    @Override
    public void deleteLast() {
        noteListRepository.remoteLastNote();
    }

    @Override
    public void update(Note note) {
        noteListRepository.updateNote(note);
    }
    @Override
    public Note getById(Long id) {
        return noteListRepository.getNoteById(id);
    }
    @PostConstruct
    public void init() {
        Note note1 = new Note();
        note1.setTitle("Title note");
        note1.setContent("Content note");
        add(note1);
        Note note2 = new Note("Title note 2","Content note 2");
        add(note2);
        Note note3 = new Note("Title note 3","Content note 3");
        add(note3);

        note3.setTitle("updated title note 3");
        update(note3);
        System.out.println(listAll());
        listAll().forEach(note -> deleteLast());
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("<<<<<<< THE END >>>>>>>");
    }
}
