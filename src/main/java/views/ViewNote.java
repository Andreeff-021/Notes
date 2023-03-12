package views;

import controllers.NoteController;
import model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewNote {
    private NoteController noteController;

    public ViewNote(NoteController userController) {
        this.noteController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        caseCreate();
                        break;
                    case READ:
                        caseRead();
                        break;
                    case LIST:
                        caseList();
                        break;
                    case DELETE:
                        caseDelete();
                        break;
                    case UPDATE:
                        caseUpdate();
                        break;
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s \n", e.getMessage());
            }
        }
    }

    private void caseUpdate() {
        String id = prompt("Идентификатор записи: ");
        String heading = prompt("Заголовок: ");
        String note = prompt("Запись: ");
        noteController.updateNote(id, heading, note);
        System.out.println("Запись изменена!");
    }

    private void caseDelete() {
        String id = prompt("Идентификатор записи: ");
        noteController.deleteNote(id);
        System.out.println("Запись уладена!");
    }

    private void caseCreate() throws Exception {
        String id = "";
        String heading = prompt("Заголовок: ");
        String note = prompt("Запись: ");
        noteController.saveNote(new Note(id, heading, note));
    }

    private void caseRead() {
        String id = prompt("Идентификатор записи: ");
        try {
            Note note = noteController.readNote(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void caseList() {
        List<Note> noteList = noteController.readNotes();
        for (Note note : noteList){
            System.out.println(note);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
