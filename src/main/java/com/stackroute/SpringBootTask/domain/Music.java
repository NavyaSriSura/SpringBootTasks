package com.stackroute.SpringBootTask.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int rating;
    private String comments;


}
