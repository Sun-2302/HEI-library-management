package org.example.entity;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Author {
    private UUID id;
    private String name;
    private String  sex;
}
