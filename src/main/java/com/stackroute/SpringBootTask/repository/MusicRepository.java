package com.stackroute.SpringBootTask.repository;

import com.stackroute.SpringBootTask.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {

}
