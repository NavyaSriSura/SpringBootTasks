package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    private String name1;
    private String comments1;
    private int rating1;
    private String name2;
    private String comments2;
    private int rating2;
    private MusicRepository musicRepository;

    @Autowired
    public MusicRepository getMusicRepository() {
        return musicRepository;
    }

    public void setMusicRepository(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveTrack(Music music) {


        Music savedTrack = musicRepository.save(music);

        return savedTrack;
    }

    @Override
    public List<Music> getTrack() {
        return (List<Music>) musicRepository.findAll();
    }

    @Override
    public Music getById(int id) {

        Optional<Music> user_id = musicRepository.findById(id);
        return user_id.get();
    }


    @Override
    public void deleteById(int id) {
        musicRepository.deleteById(id);
    }

    @Override
    public boolean updateById(Music music, int id) {
        Optional<Music> userOptional = musicRepository.findById(id);

        if (!userOptional.isPresent())
            return false;


        music.setId(id);

        musicRepository.save(music);
        return true;
    }

    @Override
    public List<Music> getByName(String name) {
        return null;
    }


}
