package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;

import java.util.List;

public interface MusicService {
    public Music saveMusic(Music music);

    public List<Music> getMusic();

    public Music getById(int id);

    public Music deleteById(int id);

    public Music updateById(Music music, int id);

    public List<Music> getByName(String name);
}
