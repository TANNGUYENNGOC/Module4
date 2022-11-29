package com.example.demo.servie;

import com.example.demo.model.Song;
import com.example.demo.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    ISongRepository songRepository;
    @Override
    public List findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Integer id) {

    }


}
