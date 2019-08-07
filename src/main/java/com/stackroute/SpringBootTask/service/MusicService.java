package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;

import java.util.List;

public interface MusicService {
    public Music saveMusic(Music music);

    public List<Music> getMusic();

    public Music getById(int id);

    public void deleteById(int id);

    public boolean updateById(Music music, int id);

    public  List<Music>   getByName(String name);
}
