package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Music;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music, Integer> {


    @Query("{name:'?0'")
    List<Music> findTitleByName(String name);
}
