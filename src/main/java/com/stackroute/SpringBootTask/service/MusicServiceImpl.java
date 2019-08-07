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
    public Music deleteById(int id) {
        musicRepository.deleteById(id);
        MusicService musicService = null;
        return musicService.getById(id);
    }

    @Override
    public Music updateById(Music music, int id) {
        Optional<Music> track = musicRepository.findById(id);
        Optional<Music> userOptional = musicRepository.findById(id);
        if (!userOptional.isPresent())
            music.setId(id);
        musicRepository.save(music);
        MusicService muzixService = null;
        return muzixService.getById(id);

    }

    @Override
    public List<Music> getByName(String name) {
        return null;
    }


}
