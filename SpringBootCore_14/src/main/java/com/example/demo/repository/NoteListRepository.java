package com.example.demo.repository;

import com.example.demo.entity.Note;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NoteListRepository {
    private List<Note> notes = new ArrayList<>();
    public List<Note> listAllNotes() {
        return this.notes;
    }
    public Note addNote(Note note) {
        if (notes.size()==0) {
            notes.add(note);
        } else {
            Note noteWithMaxId = notes.stream()
                    .max(Comparator.comparing(Note::getId))
                    .orElseThrow();
            int newNoteId = (noteWithMaxId == null) ? 1 : noteWithMaxId.getId() + 1;
            note.setId(newNoteId);
            this.notes.add(note);
        }
        return note;
    }
    public void updateNote(Note note) {
        Note temp = getNoteById((long) note.getId());
        if (temp == null) {
            throw new NoSuchElementException("note by id "+note.getId()+" is not present in list notes!!!");
        }
        temp.setTitle(note.getTitle());
        temp.setContent(note.getContent());
        //this.notes.set(note.getId(), note);
    }
    public Note getNoteById(Long id) {
        Note note = notes.stream()
                .filter(p -> p.getId()==id)
                .findAny().orElse(null);
        if (note == null) {
            throw new NoSuchElementException("note by id "+id+" is not present!!!");
        }
        return note;
    }
    public void removeNoteById(Long id) {
        this.notes.remove(id);
    }
    public void remoteLastNote() {
        int id = 0;
        id = this.notes.getLast().getId();
        if (id>0) {
            removeNoteById((long) id);
        }
    }
}
