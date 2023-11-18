package org.example.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class User {
    private String id;
    private String name;
    private String reference;
    private Character sex;
}
