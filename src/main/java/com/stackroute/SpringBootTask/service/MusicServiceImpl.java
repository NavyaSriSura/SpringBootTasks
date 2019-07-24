package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    String name1;
    String comments1;
    int rating1;
    String name2;
    String comments2;
    int rating2;
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
    public Music saveMusic(Music music) {


        Music savedMusic = musicRepository.save(music);

        return savedMusic;
    }

    @Override
    public List<Music> getMusic() {
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
        List<Music> user_id = musicRepository.findTitleByName(name);

        return user_id;
    }


}
