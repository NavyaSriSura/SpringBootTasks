package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;

import java.util.List;

public interface MusicService  {
    public Music saveMusic(Music music) throws TrackAlreadyExistsException;

    public List<Music> getMusic();

    public Music getById(int id) throws TrackNotFoundException;

    public Music deleteById(int id);

    public Music updateById(Music music, int id);

    public List<Music> getByName(String name);
}
