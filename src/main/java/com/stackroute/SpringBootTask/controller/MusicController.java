package com.stackroute.SpringBootTask.controller;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class MusicController {
    public MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("/music")
    public ResponseEntity<?> saveMusic(@RequestBody Music music) {
        ResponseEntity responseEntity;
        Music savedMusic = null;

        try {
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity("Succesfully created", HttpStatus.CREATED);
            savedMusic = musicService.saveMusic(music);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

            System.out.println(e);
        }
        return responseEntity;
    }

    @GetMapping("/track")
    public ResponseEntity<?> getAllTracks() {
        //return new ResponseEntity<List<Music>>(musicService.get(),HttpStatus.OK);
        List<Music> musicList = musicService.getMusic();
        return new ResponseEntity<List<Music>>(musicList, HttpStatus.CREATED);
    }

    @GetMapping("/music/{id}")

    public ResponseEntity<?> getById(@PathVariable int id) {

        Music music = null;

        try {
            music = musicService.getById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Music>(music, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteTrack(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            musicService.deleteById(id);
            responseEntity = new ResponseEntity<>("Track Deleted", HttpStatus.OK);

        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMusix(@RequestBody Music music, @PathVariable int id) {
        ResponseEntity<String> responseEntity;
        try {
            musicService.updateById(music, id);
            responseEntity = new ResponseEntity<String>("Update Successfull", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("/music/{name}")
    public ResponseEntity<List<Music>> getByname(@PathVariable String name) {
        List<Music> musix = musicService.getByName(name);
        return new ResponseEntity<List<Music>>(musix, HttpStatus.OK);
    }


}