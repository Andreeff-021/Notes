package model;

public class Note {
    private String id;
    private String heading;
    private String note;

    public Note(String id, String heading, String note) {
        this.id = id;
        this.heading = heading;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String toString(){
        return String.format("Идентификатор: %s\n%s\n%s", id, heading, note);
    }
}
