package org.example.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private String id;
    private String name;
    private int pageNumber;
    private int topicId;
    private String releaseDate;
    private boolean availability;
    private String id_author;

    public Book(String id, String name, int pageNumber, int topicId, String releaseDate, boolean availability) {
        this.id = id;
        this.name = name;
        this.pageNumber = pageNumber;
        this.topicId = topicId;
        this.releaseDate = releaseDate;
        this.availability = availability;
    }

}
