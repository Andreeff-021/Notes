package model;

public interface Mapper {
    public String map(Note note);
    public Note map(String line);
}
