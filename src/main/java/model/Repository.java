package model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String CreateNote(Note note);
    void deleteNote(String noteId);
    void updateNote(String id, String heading, String note);
}
