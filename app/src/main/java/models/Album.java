package models;

public class Album {
    private String title;
    private String artist;
    private String genre;
    private int coverResourceId;

    public Album(String title, String artist, String genre, int coverResourceId) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.coverResourceId = coverResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getCoverResourceId() {
        return coverResourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCoverResourceId(int coverResourceId) {
        this.coverResourceId = coverResourceId;
    }
}
