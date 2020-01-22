package com.egconley.songr;

public class Album {
    String title;
    String artist;
    int songCount;
    double length;
    String imageUrl;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public double getlength() {
        return length;
    }

    public String getimageUrl() {
        return imageUrl;
    }

    public Album(String title, String artist, int songCount, double length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

}
