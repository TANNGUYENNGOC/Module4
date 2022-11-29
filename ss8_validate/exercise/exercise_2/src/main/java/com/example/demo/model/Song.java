package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song_list")
public class Song implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if(!song.getName_song().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,800}$")){
            errors.rejectValue("name_song","name_song","Tên bài hát không chứa kí tự đặc biệt,không vượt quá 800 kí tự và không được để trống");
        }
        if (!song.getSingerName().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,300}$")){
            errors.rejectValue("singerName","singerName","Tên nghệ sĩ không được chứa kí tự đặc biệt, không vượt quá 300 kí tự và không được để trống");
        }
        if(!song.getKindOfMusic().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,1000}$")){
            errors.rejectValue("kindOfMusic","kindOfMusic","Tên thể loại không được chứa kí tự đặc biệt, không vượt quá 1000 kí tự và không được để trống");
        }
    }
}