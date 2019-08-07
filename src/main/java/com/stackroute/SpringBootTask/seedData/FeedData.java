package com.stackroute.SpringBootTask.seedData;

import com.stackroute.SpringBootTask.domain.Music;
import com.stackroute.SpringBootTask.repository.MusicRepository;
import com.stackroute.SpringBootTask.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sun.tools.java.Environment;


@Component

@PropertySource("application.properties")
public class FeedData implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private MusicRepository musicRepository;

    @Value("${song.1.rating}")
    private int rating1;
    @Value("${song.1.name}")
    private String name1;
    @Value("${song.1.comment}")
    private String comment1;
    @Value("${song.2.rating}")
    private int rating2;
    @Value("${song.2.name}")
    private String name2;
    @Value("${song.2.comment}")
    private String comment2;
    @Autowired
    Environment env;
    @Autowired
    MusicService musicService;

    @Override
    public void run(String... args) throws Exception {

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        musicRepository.save(new Music(1, name1, rating1, comment1));
        musicRepository.save(new Music(2, name2, rating2, comment2));
    }
}
