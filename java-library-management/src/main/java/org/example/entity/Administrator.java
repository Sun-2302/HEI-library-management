package org.example.entity;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Administrator extends User{
    private String password;

    public Administrator(UUID id, String name, String reference, String sex, String password) {
        super(id, name, reference, sex);
        this.password = password;
    }
}
