package org.example.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BookTransaction {
    private String id;
    private String bookId;
    private String visitorId;
    private Date borrowDate;
    private Date returnDate;
}
