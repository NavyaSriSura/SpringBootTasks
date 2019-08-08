package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.exceptions.MusicAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.MusicNotFoundException;

import java.util.List;

public interface MusicService {
    public Music saveMusic(Music music) throws MusicAlreadyExistsException;

    public List<Music> getMusic();

    public Music getById(int id) throws MusicNotFoundException;

    public Music deleteById(int id);

    public Music updateById(Music music, int id);

    public List<Music> getByName(String name);
}
