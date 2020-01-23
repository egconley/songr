package com.egconley.songr;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "album_id", unique = true, nullable = false)
    long album_id;
    String title;
    String artist;
    Integer songCount;
    double length;
    String imageUrl;

    @OneToMany(mappedBy="album")
    private List<Song> song;

    public long getAlbum_id() { return album_id; }

    public String getTitle() { return title; }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public double getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Song> getSong() {
        return song;
    }

    public Album() {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(String title, String artist, Integer songCount, double length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }



}
