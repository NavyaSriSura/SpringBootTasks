package com.stackroute.SpringBootTask.service;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.exceptions.MusicAlreadyExistsException;
import com.stackroute.SpringBootTask.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MusicServiceImplTest
{

    Music music;

    //Create a mock for MusicRepository
    @Mock
    MusicRepository musicRepository;

    //Inject the mocks as dependencies into MusicServiceImpl
    @InjectMocks
    MusicServiceImpl musicService;
    List<Music> list= null;

    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setName("Vasavi");
        music.setId(1);
        music.setRating(10);
        music.setComments("Good");
        list = new ArrayList<>();
        list.add(music);

    }

    @Test
    public void saveMusicTestSuccess() throws MusicAlreadyExistsException {

        when(musicRepository.save((Music) any())).thenReturn(music);
        Music savedMusic = musicService.saveMusic(music);
        Assert.assertEquals(music,savedMusic);

        //verify here verifies that musicRepository save method is only called once
        verify(musicRepository,times(1)).save(music);

    }


    @Test
    public void getAllMusics(){

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> musiclist = musicService.getMusic();
        Assert.assertEquals(list,musiclist);
    }

    @Test
    public void testUpdateMusicService() throws MusicNotFoundException{
        when(musicRepository.existsById(anyInt())).thenReturn(true);
        boolean updateMusic= musicServiceImpl.UpdateMusic(music,1);

        Assert.assertEquals(true,updateMusic);

        verify(musicRepository, Mockito.times(1)).save(music);
        verify(musicRepository, Mockito.times(1)).existsById(anyInt());

    }
    @Test
    public void deleteMusicTestSuccess() throws MusicAlreadyExistsException {

        musicRepository.delete(music);
        boolean deletedMusic=musicRepository.existsById(20);
        assertEquals(false,deletedMusic);
    }

}