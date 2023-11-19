package org.example.entity;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class User {
    private UUID id;
    private String name;
    private String reference;
    private String sex;

}
