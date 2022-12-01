package com.example.demo.dto;

import com.example.demo.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SongDto implements Validator {

    @Id

    private int id;
    private String name_song;
    private String singerName;
    private String kindOfMusic;

    public SongDto(int id, String name_song, String singerName, String kindOfMusic) {
        this.id = id;
        this.name_song = name_song;
        this.singerName = singerName;
        this.kindOfMusic = kindOfMusic;
    }

    public SongDto() {
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
        SongDto songDto = (SongDto) target;
        if(!songDto.getName_song().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,800}$")){
            errors.rejectValue("name_song","name_song","Tên bài hát không chứa kí tự đặc biệt,không vượt quá 800 kí tự và không được để trống");
        }
        if (!songDto.getSingerName().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,300}$")){
            errors.rejectValue("singerName","singerName","Tên nghệ sĩ không được chứa kí tự đặc biệt, không vượt quá 300 kí tự và không được để trống");
        }
        if(!songDto.getKindOfMusic().matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+){1,1000}$")){
            errors.rejectValue("kindOfMusic","kindOfMusic","Tên thể loại không được chứa kí tự đặc biệt, không vượt quá 1000 kí tự và không được để trống");
        }
    }
}
