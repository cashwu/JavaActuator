package com.cashwu.javaactuator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "notes",
          enableByDefault = true)
public class NotesEndpoint {

    private final List<Note> notes = new ArrayList<>();

    @ReadOperation
    public List<Note> notes() {
        return notes;
    }

    @WriteOperation
    public List<Note> addNote(String text) {
        notes.add(new Note(text));
        return notes;
    }

    @DeleteOperation
    public List<Note> deleteNote(int index) {
        if (index < notes.size()) {
            notes.remove(index);
        }
        return notes;
    }

}


@Getter
class Note {
    private final Date time = new Date();
    private final String text;

    public Note(String text) {
        this.text = text;
    }

}
