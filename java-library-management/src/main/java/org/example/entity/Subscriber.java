package org.example.entity;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subscriber extends User{
    public Subscriber(String id, String name, String reference, String sex) {
        super(id, name, reference, sex);
    }
}
