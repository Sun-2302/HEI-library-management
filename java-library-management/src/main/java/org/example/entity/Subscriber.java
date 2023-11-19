package org.example.entity;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Subscriber extends User{
    public Subscriber(UUID id, String name, String reference, String sex) {
        super(id, name, reference, sex);
    }

    public String toString() {
        return "Subscriber{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", reference='" + super.getReference() + '\'' +
                ", sex='" + super.getSex() + '\'' +
                '}';
    }
}
