package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song_list")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String name_song;

    @Column(columnDefinition = "TEXT")
    private String singerName;

    @Column(columnDefinition = "TEXT")
    private String kindOfMusic;

    public Song(int id, String name_song, String singerName, String kindOfMusic) {
        this.id = id;
        this.name_song = name_song;
        this.singerName = singerName;
        this.kindOfMusic = kindOfMusic;
    }

    public Song() {
    }

    public Song(String name_song, String singerName, String kindOfMusic) {
        this.name_song = name_song;
        this.singerName = singerName;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_song() {
        return name_song;
    }

    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

}