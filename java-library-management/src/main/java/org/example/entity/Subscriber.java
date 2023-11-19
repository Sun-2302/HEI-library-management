package org.example.entity;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subscriber extends User{
    public Subscriber(UUID id, String name, String reference, String sex) {
        super(id, name, reference, sex);
    }

}
