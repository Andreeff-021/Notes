package controllers;

import model.Note;
import model.Repository;

import java.util.List;

public class NoteController {
    private final Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }
    public void saveNote(Note note){
        repository.CreateNote(note);
    }
    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public List<Note> readNotes(){
        List<Note> notes = repository.getAllNotes();
        return notes;
    }

    public void deleteNote(String noteId){
        repository.deleteNote(noteId);
    }

    public void updateNote(String id, String heading, String note){
        repository.updateNote(id, heading, note);
    }
}
